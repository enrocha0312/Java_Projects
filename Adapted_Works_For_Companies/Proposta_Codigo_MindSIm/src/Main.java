import Entities.Pessoa;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Maneira 1
        Map<String, Map<Integer, String>> tabela1 = new HashMap<>();

        String filePath = "D:\\Codigos_VSCODE\\Programas_didaticos_Java\\exemplo_arquivo_manipulacao.csv";

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                new FileInputStream(filePath), StandardCharsets.ISO_8859_1))) {
            String line = bufferedReader.readLine();
            String [] attributes = line.split(";");
            for(int i = 0; i< attributes.length;i++){
                tabela1.put(attributes[i], new HashMap<>());
            }
            int id = 1;
            line = bufferedReader.readLine();
            while(line!=null){
                attributes = line.split(";");
                tabela1.get("Nome").put(id, attributes[0]);
                tabela1.get("Idade").put(id, attributes[1]);
                tabela1.get("Sexo").put(id, attributes[2]);
                tabela1.get("Escolaridade").put(id, attributes[3]);
                tabela1.get("Cidade").put(id, attributes[4]);
                line = bufferedReader.readLine();
                id++;
            }

        }catch (IOException ex) {
            ex.printStackTrace();
        }


        //filtragens, ordenações, etc
        //EXEMPLOS
        //Trazer quem é do Rio
        Map<Integer, String> mapaFiltradoRiodeJaneiro =
                 tabela1.get("Cidade").entrySet()
                .stream()
                .filter(e -> e.getValue().equalsIgnoreCase("Rio de Janeiro"))
                .collect(Collectors.toMap(e ->  e.getKey(), e-> e.getValue()));

        List<Integer> listaDeIdsDoRio = mapaFiltradoRiodeJaneiro.entrySet().stream().map(e -> e.getKey()).collect(Collectors.toList());

        Optional<List<String>> moradoresDoRioDeJaneiro =
                Optional.of(
                tabela1.get("Nome").entrySet()
                .stream()
                .map(e -> {
                    if(listaDeIdsDoRio.contains(e.getKey())){
                    return e.getValue();
                    }
                    return null;
                }).filter(e -> e!=null)
                .collect(Collectors.toList()));
        System.out.println("MORAM NO RIO");
        for(String nome : moradoresDoRioDeJaneiro.get()){
            System.out.println(nome);
        }
        List<Integer> idades = new ArrayList<>();
        //Trazer idades em ordem crescente
        for(String idade : tabela1.get("Idade").values()){
            idades.add(Integer.parseInt(idade));
        }
        Collections.sort(idades,Collections.reverseOrder());

        for(Integer idade : idades){
            System.out.println(idade);
        }

        //QUEM É O MAIS VELHO?

        Optional<Integer>  idMaisVelho = tabela1.get("Idade").entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(e -> e.getKey()).findFirst();

        System.out.println("A pessoa mais velha da lista é " + tabela1.get("Nome").entrySet()
                .stream().filter(e -> e.getKey() == idMaisVelho.get())
                .findFirst().get().getValue());


        /*Maneira 2*/

        List<Pessoa> pessoas = new ArrayList<>();

        try(BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(
                new FileInputStream(filePath), StandardCharsets.ISO_8859_1))){
            String line = bufferedReader.readLine();
            line = bufferedReader.readLine();
            //leu a segunda
            while (line != null){
                String [] attributes = line.split(";");
                pessoas.add(new Pessoa(Integer.parseInt(attributes[1]), attributes[0],
                        attributes[4], attributes[3], attributes[2].charAt(0)));
                line = bufferedReader.readLine();
            }


        }catch (IOException ex){
            ex.printStackTrace();

        }


        System.out.println("HOMENS DA LISTA\n");
        for(Pessoa p : pessoas.stream().filter(p -> p.getSexo().equals('M')).collect(Collectors.toList())){
            System.out.println(p.getNome());
        }

        System.out.println("Pessoa mais nova da lista:\n" + pessoas.stream().sorted(Comparator.comparing(p -> p.getIdade())).findFirst().get().getNome());

        System.out.println("Pessoa mais velha da lista:\n" + pessoas.stream().sorted(Comparator.comparing(Pessoa::getIdade).reversed()).findFirst().get().getNome() );

        System.out.println("Mulheres com ensino superior\n");

        for (Pessoa p : pessoas.stream()
                .filter(e -> (e.getSexo().equals('F') && e.getEscolaridade().equalsIgnoreCase("Ensino Superior")))
                .collect(Collectors.toList())){
            System.out.println(p.getNome());
        }

        System.out.println("Pessoas com idade abaixo da média\n");
        System.out.println("Média de idade: " + meanPeople(pessoas));
        for (Pessoa p: pessoas.stream()
                .filter(p -> p.getIdade() > meanPeople(pessoas))
                .collect(Collectors.toList())){
            System.out.println(p.getNome());
        }
    }

    public static double meanPeople(List<Pessoa> ps){
        int mean = 0;
        for(Pessoa p: ps){
            mean += p.getIdade();
        }
        return mean/ ps.size();
    }
}