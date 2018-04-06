package com.stackAndQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by major on 2017/12/4.
 */
public class CatAndDogQueue {


    private Queue<PetEnterQueue> catQueue;
    private Queue<PetEnterQueue> dogQueue;
    private long count = 0;
    public CatAndDogQueue() {
        catQueue = new LinkedList<>();
        dogQueue = new LinkedList<>();
    }

    public void add(Pet pet) {
        PetEnterQueue petEnterQueue = new PetEnterQueue(pet, this.count++);
        if(pet.type.equals("dog")) {
            this.dogQueue.add(petEnterQueue);
        } else if(pet.type.equals("cat")) {
            this.catQueue.add(petEnterQueue);
        } else {
            throw new IllegalArgumentException("the type of pet is not compatible");
        }
    }

    public List<Pet> pollAll() {

        List<Pet> result = new LinkedList<>();
        while(!catQueue.isEmpty() && !dogQueue.isEmpty()) {
            if(catQueue.peek().count > dogQueue.peek().count) {
                result.add(catQueue.poll().pet);
            } else {
                result.add(dogQueue.poll().pet);
            }
        }
        if(catQueue.isEmpty()) {
            while (!dogQueue.isEmpty()) {
                result.add(dogQueue.poll().pet);
            }
        }
        if(dogQueue.isEmpty()) {
            while (!catQueue.isEmpty()) {
                result.add(dogQueue.poll().pet);
            }
        }
        return result;
    }

    class PetEnterQueue {
        public long count;
        public Pet pet;
        public PetEnterQueue(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }
    }

    class Pet {
        public String getType() {
            return type;
        }

        public Pet(String type) {
            this.type = type;
        }

        private String type;


    }

    class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }

    class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }
}
