package org.example;

import java.util.UUID;

public class Computer {
  private int ram;
  private int cores;
  private String name;
  private UUID number;
  private OperatingSystem operatingSystem;
  private int ramUsed;

  public Computer(Computer other) {
    this.ram = other.ram;
    this.cores = other.cores;
    this.name = other.name;
    this.operatingSystem = other.operatingSystem;
    this.number = other.number;
    this.ramUsed = other.ramUsed;
  }

  private Computer(int ram, int cores, String name, OperatingSystem operatingSystem, UUID id, int ramUsed) {
    this.ram = ram;
    this.cores = cores;
    this.name = name;
    this.operatingSystem = operatingSystem;
    this.number = id;
    this.ramUsed = ramUsed;
  }

  public static ComputerBuilder builder() {
    return new ComputerBuilder();
  }

  @Override
  public String toString() {
    return "Computer{" +
        "ram=" + ram +
        ", cores=" + cores +
        ", name='" + name + '\'' +
        ", number=" + number +
        ", operatingSystem=" + operatingSystem +
        ", ramUsed=" + ramUsed +
        '}';
  }

  enum OperatingSystem{
    Windows,
    Linux,
    MacOS
  }

  public boolean loadProgram(int ramNeeded) {
    boolean result = false;
    if (ramNeeded + ramUsed < ram) {
      result = true;
      ramUsed += ramNeeded;
    }
    return result;
  }

  public int closeProgram(int ramUsedForProgram) {
    ramUsed -= ramUsedForProgram;
    return this.ramUsed;
  }

  public int restart() {
    this.ramUsed = (int)((ram *1000 * 0.3))/1000;
    return this.ramUsed;
  }

  public static class ComputerBuilder {
    private int ram;
    private int cores;
    private String name;
    private UUID number;
    private OperatingSystem operatingSystem;
    private int ramUsed;

    public ComputerBuilder ram(int ram) {
      this.ram = ram;
      this.ramUsed = (int)((ram *1000 * 0.3))/1000;
      return this;
    }

    public ComputerBuilder cores(int cores) {
      this.cores = cores;
      return this;
    }

    public ComputerBuilder name(String name) {
      this.name = name;
      return this;
    }

    private ComputerBuilder number(UUID id) {
      this.number = id;
      return this;
    }

    public ComputerBuilder number() {
      this.number = UUID.randomUUID();
      return this;
    }

    public ComputerBuilder operatingSystem(OperatingSystem operatingSystem) {
      this.operatingSystem = operatingSystem;
      return this;
    }

    public Computer build() {
      return new Computer(ram, cores, name, operatingSystem, number, ramUsed);
    }
  }

}
