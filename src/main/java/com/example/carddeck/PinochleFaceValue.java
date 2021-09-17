package com.example.carddeck;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Set;
import java.util.TreeSet;

public class PinochleFaceValue implements FaceValue, Comparable <PinochleFaceValue> {

    public static final FaceValue NINE = new StandardFaceValue("nine", 9);
    public static final FaceValue TEN = new StandardFaceValue("ten", 10);
    public static final FaceValue JACK = new StandardFaceValue("jack", 11);
    public static final FaceValue QUEEN = new StandardFaceValue("queen", 12);
    public static final FaceValue KING = new StandardFaceValue("king", 13);
    public static final FaceValue ACE = new StandardFaceValue("ace", 14);

    private final String name;
    private final int ordinal;

    public PinochleFaceValue(String name, int ordinal){
        this.name = name;
        this.ordinal = ordinal;
    }

    @Override
    public int compareTo(PinochleFaceValue that) {
        if (this.ordinal > that.ordinal) {
            return 1;
        } else if (this.ordinal < that.ordinal){
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public int ordinal() {
        return ordinal;
    }

    @Override
    public String toString(){
        return name;
    }

    public static Set<FaceValue> values(){
        Set<FaceValue> set = new TreeSet<>();

        Field[] fields = PinochleFaceValue.class.getFields();
        for(Field field : fields){
            if (Modifier.isStatic(field.getModifiers())) {
                try {
                    set.add((PinochleFaceValue) field.get(null));
                } catch (IllegalAccessException e){
                    e.printStackTrace();
                }
            }
        }
        return set;
    }
}
