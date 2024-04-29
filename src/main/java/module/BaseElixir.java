package module;

import java.util.HashMap;
import java.util.Map;

public class BaseElixir {

    private Map<String, int[]> wisePersons;
    private int ductilityCount = 0;
    private int totalDuctilityCount = 0;
    private String beforeSelectWisePerson;
    private int beforeDuctilityCount = 0;

    public BaseElixir(int totalDuctilityCount) {

        this.totalDuctilityCount = totalDuctilityCount;

        this.wisePersons = new HashMap<>();
        this.wisePersons.put("rebedo", new int[totalDuctilityCount]);
        this.wisePersons.put("viriditas", new int[totalDuctilityCount]);
        this.wisePersons.put("citrini", new int[totalDuctilityCount]);

        for (String wisePerson: this.wisePersons.keySet()) {
            this.wisePersons.get(wisePerson)[0] = 1;
        }

    }

    public void select(String selectWisePerson) {
        if(ductilityCount != 0) {
            for (String wisePerson: this.wisePersons.keySet()) {
                int[] wisePersonArray  = this.wisePersons.get(wisePerson);

                if(wisePerson.equals(selectWisePerson)) {
                    if(selectWisePerson.equals(this.beforeSelectWisePerson)) {
                        if(wisePersonArray[this.ductilityCount - 1] >= 3) {
                            wisePersonArray[this.ductilityCount] = 1;
                        } else {
                            wisePersonArray[this.ductilityCount] += wisePersonArray[this.ductilityCount - 1] + 1;
                        }
                    } else {
                        wisePersonArray[this.ductilityCount] = 1;
                    }
                } else {
                    if(wisePerson.equals(this.beforeSelectWisePerson)) {
                        wisePersonArray[this.ductilityCount] = 1;
                    } else {
                        if(wisePersonArray[this.ductilityCount - 1] >= 6) {
                            wisePersonArray[this.ductilityCount] = 1;
                        } else {
                            wisePersonArray[this.ductilityCount] += wisePersonArray[this.ductilityCount - 1] + 1;
                        }
                    }
                }
                this.wisePersons.put(wisePerson, wisePersonArray);
            }
        }
        this.beforeSelectWisePerson = selectWisePerson;
        this.ductilityCount++;

    }

    public int clear(){

        this.wisePersons.put("rebedo", new int[this.totalDuctilityCount]);
        this.wisePersons.put("viriditas", new int[this.totalDuctilityCount]);
        this.wisePersons.put("citrini", new int[this.totalDuctilityCount]);
        this.ductilityCount = 0;
        this.beforeSelectWisePerson = null;

        return 0;
    }

    public void print() {
        for (String wisePerson: this.wisePersons.keySet()) {
            for (int i = 0; i < this.totalDuctilityCount; i++) {
                System.out.println(wisePerson + " " + i + " :" + this.wisePersons.get(wisePerson)[i]);
            }
        }
        System.out.println("ductilityCount: " + this.ductilityCount);
        System.out.println("beforeSelectWisePerson: " + this.beforeSelectWisePerson);
    }

    public void resetSelectSimulation() {
        for (String wisePerson: this.wisePersons.keySet()) {
            int[] wisePersonArray  = this.wisePersons.get(wisePerson);

            for (int i = ductilityCount; i < this.totalDuctilityCount; i++) {
                wisePersonArray[i] = 0;
            }

            this.wisePersons.put(wisePerson, wisePersonArray);
        }
    }

    public void selectSimulation() {
        this.beforeDuctilityCount = this.ductilityCount;

        for (int i = this.ductilityCount; i < this.totalDuctilityCount; i++) {
            select(this.beforeSelectWisePerson);
        }

        this.ductilityCount = this.beforeDuctilityCount;

    }


}

