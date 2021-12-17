package com.liusx.jvm;

/**
 * @author ：liusx
 * @date ：Created in 2021/12/15 15:01
 * @description：虚拟机创建对象时相关细节探究
 * @version: 1.0
 */
public class CreateObjectExplore {

    byte bytes;
    short shorts;
    int ints;
    long longs;
    float floats;
    double doubles;
    char chars;
    boolean booleans;

    String strings;
    Byte byteB;
    Short shortS;
    Integer integer;
    Long longL;
    Float floatF;
    Double doubleD;

    public static void main(String[] args) {
        CreateObjectExplore createObjectExplore = new CreateObjectExplore();
        System.out.println(createObjectExplore.toString());
    }


    public CreateObjectExplore() {
        super();
    }

    @Override
    public String toString() {
        return "CreateObjectExplore{" +
                "bytes=" + bytes +
                ", shorts=" + shorts +
                ", ints=" + ints +
                ", longs=" + longs +
                ", floats=" + floats +
                ", doubles=" + doubles +
                ", chars=" + chars +
                ", booleans=" + booleans +
                ", strings='" + strings + '\'' +
                ", byteB=" + byteB +
                ", shortS=" + shortS +
                ", integer=" + integer +
                ", longL=" + longL +
                ", floatF=" + floatF +
                ", doubleD=" + doubleD +
                '}';
    }
}
