package org.example;

import junit.framework.TestCase;

public class ComputerTest extends TestCase {

    public void testLoadProgram_ranOfMemory() {
        Computer computer = Computer.builder()
                .name("Acer Nitro 5")
                .cores(8)
                .ram(16)
                .operatingSystem(Computer.OperatingSystem.Windows)
                .number()
                .build();

        assertFalse(computer.loadProgram(20));
    }

    public void testLoadProgram_ordinaryCase() {
        Computer computer = Computer.builder()
                .name("Acer Nitro 5")
                .cores(8)
                .ram(16)
                .operatingSystem(Computer.OperatingSystem.Windows)
                .number()
                .build();

        assertTrue(computer.loadProgram(3));
    }

    public void testCloseProgram() {
        Computer computer = Computer.builder()
                .name("Acer Nitro 5")
                .cores(8)
                .ram(20)
                .operatingSystem(Computer.OperatingSystem.Windows)
                .number()
                .build();

        computer.loadProgram(3);

       assertEquals(6, computer.closeProgram(3));
    }

    public void testRestart_ordinaryCase() {
        Computer computer = Computer.builder()
                .name("Acer Nitro 5")
                .cores(8)
                .ram(20)
                .operatingSystem(Computer.OperatingSystem.Windows)
                .number()
                .build();

        computer.loadProgram(4);
        computer.loadProgram(2);
        computer.loadProgram(3);

        assertEquals(6, computer.restart());
    }

}