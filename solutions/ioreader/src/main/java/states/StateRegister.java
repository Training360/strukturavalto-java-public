package states;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StateRegister {


    private List<State> states = new ArrayList<>();



    public void readStatesFromFile(String fileName){
        Path path = Path.of("src/main/resources/"+fileName);

        try(BufferedReader br = Files.newBufferedReader(path)){

            String line;
            while((line=br.readLine())!=null){
                String[] temp= line.split("-");
                State s = new State(temp[0],temp[1]);
                states.add(s);
            }



        } catch (IOException e) {
            throw new IllegalStateException("Can't read file!",e);
        }
    }




    public String findCapitalByStateName(String stateName){

        for(State state:states){
            if(stateName.equals(state.getStateName())){
                return  state.getCapital();
            }
        }
        throw new IllegalArgumentException("No state with this name!");
    }



    public List<State> getStates() {
        return new ArrayList<>(states);
    }
}
