package com.mycom.designpatterns.factory.abstractfactory1;

public class Client {

  public static void main(String[] args) {
    FactoryPC ftyAmd = new FactoryAmdPC();
    FactoryPC ftyIntel = new FactoryIntelPC();
    
    HPPC amdhppc = ftyAmd.createHPPC("AMD_HP_PC_001");
    IBMPC amdibmpc = ftyAmd.createIBMPC("AMD_IBM_PC_002");
    
    HPPC intelhppc = ftyIntel.createHPPC("Intel_HP_PC_003");
    IBMPC intelibmpc = ftyIntel.createIBMPC("Intel_IBM_PC_004");
    
    amdhppc.printName();
    amdibmpc.printName();
    intelhppc.printName();
    intelibmpc.printName();

  }

}
