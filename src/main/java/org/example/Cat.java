package org.example;


public class Cat {

    private String name;
    private int weight;
    private boolean isAngry;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) throws IncorrectCatWeightException {

        if (weight < 0){
            throw new IncorrectCatWeightException("Покорми котика! Путь он весит хоть сколько-нибудь.");
        }
        if (weight > 30){
            throw new IncorrectCatWeightException("Пожалей котика! Он слишком тяжелый.");
        }

        this.weight = weight;
    }

    public boolean isAngry() {
        return isAngry;
    }

    public void setAngry(boolean angry) {
        isAngry = angry;
    }

    public Cat(String name, int weight, boolean isAngry) throws IncorrectCatWeightException {
        this.name = name;
        setWeight(weight);
        this.isAngry = isAngry;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", isAngry=" + isAngry +
                '}';
    }
}
