package br.edu.utfpr;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class SalesReader {

    private final List<Sale> sales;

    public SalesReader(String salesFile) {

        final var dataStream = ClassLoader.getSystemResourceAsStream(salesFile);

        if (dataStream == null) {
            throw new IllegalStateException("File not found or is empty");
        }

        final var builder = new CsvToBeanBuilder<Sale>(new InputStreamReader(dataStream, StandardCharsets.UTF_8));

        sales = builder
                .withType(Sale.class)
                .withSeparator(';')
                .build()
                .parse();
    }

    public BigDecimal totalOfCompletedSales() {
        return sales.stream().filter(s -> s.isCompleted()).map(s -> s.getValue()).reduce((v1, v2) -> v1.add(v2)).get();
    }

    public BigDecimal totalOfCancelledSales() {
        return sales.stream().filter(s -> s.isCancelled()).map(s -> s.getValue()).reduce((v1, v2) -> v1.add(v2)).get();
    }

    public Optional<Sale> mostRecentCompletedSale() {
        // TODO implementar
        return sales.stream().filter(s->s.isCompleted()).sorted((s1,s2) -> s2.getSaleDate().compareTo(s1.getSaleDate())).findFirst();
    }

    public long daysBetweenFirstAndLastCancelledSale() {
        Sale firstCancelledSale = sales.stream().filter(s->s.isCancelled()).sorted(Comparator.comparing(Sale::getSaleDate)).findFirst().get();
        Sale lastCancelledSale = sales.stream().filter(s->s.isCancelled()).sorted((s1,s2) -> s2.getSaleDate().compareTo(s1.getSaleDate())).findFirst().get();
        return firstCancelledSale.getSaleDate().until(lastCancelledSale.getSaleDate(),ChronoUnit.DAYS);
    }

    public BigDecimal totalCompletedSalesBySeller(String sellerName) {
        // TODO implementar
        return sales.stream().filter(s-> s.getSeller().equals(sellerName) && s.isCompleted())
                .map(s -> s.getValue())
                .reduce((s1,s2) -> s1.add(s2)).get();
    }

    public long countAllSalesByManager(String managerName) {
        return sales.stream().filter(s -> s.getManager().equals(managerName)).count();
    }

    public BigDecimal totalSalesByStatusAndMonth(Sale.Status status, Month... months) {
        // TODO implementar
        BigDecimal bigDecimal = BigDecimal.ZERO;
        for(Month  m: months){
            bigDecimal = bigDecimal.add(sales.stream()
                    .filter(s-> s.getStatus().equals(status) && s.getSaleDate().getMonth().equals(m))
                    .map(s -> s.getValue())
                    .reduce((s1,s2)->s1.add(s2))
                    .get());
        }
        return bigDecimal;
    }

    public Map<String, Long> countCompletedSalesByDepartment() {
        // TODO implementar
        Map<String, Long> map = new HashMap<>();
        sales.stream().map(s -> s.getDepartment()).collect(toList()).forEach(d -> {
            map.put(d, sales.stream().filter(s->s.getDepartment().equals(d) && s.isCompleted()).count());
        });
        return map;
    }

    public Map<Integer, Map<String, Long>> countCompletedSalesByPaymentMethodAndGroupingByYear() {
        // TODO implementar
        Map<Integer, Map<String,Long>> map = new TreeMap<>();
        sales
                .stream()
                .map(s-> s.getSaleDate().getYear())
                .distinct()
                .forEach(y -> map.put(y, new HashMap<>()));
        map.keySet().forEach(k->{
            sales
                    .stream()
                    .map(s-> s.getPaymentMethod())
                    .distinct()
                    .forEach(p -> {
                        map.get(k).put(p, sales
                                .stream()
                                .filter(s-> s.getPaymentMethod().equals(p) && s.getSaleDate().getYear()==k && s.isCompleted())
                                .count());
                    });
        });
        return map;
    }

    public Map<String, BigDecimal> top3BestSellers() {
        // TODO implementar

        /*
         * Teste pergunta 2
         * */
        var teste = sales.stream().map(s->s.getManager())
                .distinct()
                .map(manager-> Map.of(manager, sales.stream().filter(s ->s.isCancelled() && (
                                s.getSaleDate().getYear() >= 2013 && s.getSaleDate().getYear() <=2014) && s.getManager().equals(manager))
                                .map(s->s.getValue())
                                .reduce((s1,s2)->s1.add(s2))
                                .get()
                        ))
                .filter(m-> m.containsKey("Amauri Castro") ||
                        m.containsKey("Elenice Mendes") ||
                        m.containsKey("Raimundo Moraes") ||
                        m.containsKey("Roberta Camargo") ||
                        m.containsKey("Luiz Miranda") )
                .sorted((m1,m2) -> m2.values().stream().findFirst().get().compareTo(m1.values().stream().findFirst().get()))
                .collect(toList());

        Map<String,BigDecimal> map = new HashMap<>();
        sales
                .stream()
                .map(s->s.getSeller())
                .distinct()
                .map(seller -> Map.of(
                        seller, sales
                                .stream()
                                .filter(s-> s.getSeller().equals(seller) && s.isCompleted())
                                .map(s->s.getValue())
                                .reduce((s1,s2)-> s1.add(s2))
                                .get()
                )).
                sorted((m1,m2) -> m2.values().stream().findFirst().get().compareTo(m1.values().stream().findFirst().get()))
                .limit(3)
                .forEach(m -> map.put(m.keySet().stream().findFirst().get(), m.values().stream().findFirst().get()));
        return map
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(e->e.getKey(),e->e.getValue(), (e1,e2)->e1, LinkedHashMap::new));
    }
}
