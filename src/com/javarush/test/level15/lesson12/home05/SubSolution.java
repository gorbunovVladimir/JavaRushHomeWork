package com.javarush.test.level15.lesson12.home05;

/**
 * Created by Vl on 25.02.2015.
 */
public class SubSolution extends Solution
{
    public SubSolution(Object pub1){super(pub1);}
    public SubSolution(String pub2){super(pub2);}
    public SubSolution(Integer pub3){super(pub3);}

    protected SubSolution(Character prot1){super(prot1);}
    protected SubSolution(Double prot2) {super(prot2); }
    protected SubSolution(Exception prot3){ super(prot3); }

    private SubSolution(Number priv1){}
    private SubSolution(Boolean priv2){}
    private SubSolution(Float priv3){}

    SubSolution(){super();}
    SubSolution(Boolean bezm2,int bezm1){super(bezm2,bezm1);}
    SubSolution(Float bezm3, int bezm4){super(bezm3,bezm4);}
}
