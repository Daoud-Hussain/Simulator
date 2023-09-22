import java.util.Scanner;

public class ISA_Simulator {
    static int[] registers = new int[10];
    static int[] memory = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter number of instructions to be executed: ");
        int count = scanner.nextInt();

        while (count > 0) {
            while (true) {
                System.out.println("Enter Instruction type \n1. Load\n2. Store\n3. Add: ");
                int instruction = scanner.nextInt();
                if (instruction == 1) {
                    System.out.print("Enter Register Number: ");
                    int registerNo = scanner.nextInt();
                    System.out.print("Enter Memory Address: ");
                    int memoryAddress = scanner.nextInt();
                    load(instruction, registerNo, memoryAddress);
                    break;
                } else if (instruction == 2) {
                    System.out.print("Enter Register Number: ");
                    int registerNo = scanner.nextInt();
                    System.out.print("Enter Memory Address: ");
                    int memoryAddress = scanner.nextInt();
                    store(instruction, registerNo, memoryAddress);
                    break;
                } else if (instruction == 3) {
                    System.out.print("Enter Register 1 Number: ");
                    int registerNo1 = scanner.nextInt();
                    System.out.print("Enter Register 2 Number: ");
                    int registerNo2 = scanner.nextInt();
                    add(instruction, registerNo1, registerNo2);
                    break;
                } else {
                    System.out.println("Wrong input! Enter again\n");
                }
            }

            count--;
        }
    }

    static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + "   ");
        }
    }

    static void load(int opp, int reg1, int mem) {
        System.out.println("**************************ISA Simulator**************************");
        int cycleCnt = 1;
        int ansVal = 0;
        while (cycleCnt <= 3) {
            System.out.println("*****************************Cycle # " + cycleCnt + "***************************");
            System.out.println("Fetch Instruction    Decode Instruction   Execute Instruction");

            if (cycleCnt == 1) {
                System.out.println(opp + "     " + reg1 + "     " + mem);
            } else if (cycleCnt == 2) {
                System.out.println(opp + "     " + reg1 + "     " + mem + "        LOAD");
                System.out.println("                     Register R" + reg1);
                System.out.println("                     Memory   R" + mem);
                ansVal = memory[mem - 1];
            } else if (cycleCnt == 3) {
                System.out.println(opp + "     " + reg1 + "     " + mem + "        LOAD                 Register Updated");
                System.out.println("                     Register R" + reg1);
                System.out.println("                     Memory   R" + mem);
                registers[reg1 - 1] = ansVal;
            }
            System.out.print("Register: ");
            printArray(registers);
            System.out.println();
            System.out.println("#################################################################");
            System.out.print("Memory: ");
            printArray(memory);
            System.out.println("\n\n");
            cycleCnt++;
        }
    }

    static void store(int opp, int reg1, int mem) {
        System.out.println("**************************ISA Simulator**************************");
        int cycleCnt = 1;
        int ansVal = 0;
        while (cycleCnt <= 3) {
            System.out.println("*****************************Cycle # " + cycleCnt + "***************************");
            System.out.println("Fetch Instruction    Decode Instruction   Execute Instruction");

            if (cycleCnt == 1) {
                System.out.println(opp + "     " + reg1 + "     " + mem);
            } else if (cycleCnt == 2) {
                System.out.println(opp + "     " + reg1 + "     " + mem + "        LOAD");
                System.out.println("                     Register R" + reg1);
                System.out.println("                     Memory   R" + mem);
                ansVal = registers[reg1 - 1];
            } else if (cycleCnt == 3) {
                System.out.println(opp + "     " + reg1 + "     " + mem + "        LOAD                 Register Updated");
                System.out.println("                     Register R" + reg1);
                System.out.println("                     Memory   R" + mem);
                memory[mem - 1] = ansVal;
            }
            System.out.print("Register: ");
            printArray(registers);
            System.out.println();
            System.out.println("#################################################################");
            System.out.print("Memory: ");
            printArray(memory);
            System.out.println("\n\n");
            cycleCnt++;
        }
    }

    static void add(int opp, int reg1, int reg2) {
        System.out.println("**************************ISA Simulator**************************");
        int cycleCnt = 1;
        int ansVal = 0;
        while (cycleCnt <= 3) {
            System.out.println("*****************************Cycle # " + cycleCnt + "***************************");
            System.out.println("Fetch Instruction    Decode Instruction   Execute Instruction");

            if (cycleCnt == 1) {
                System.out.println(opp + "     " + reg1 + "     " + reg2);
            } else if (cycleCnt == 2) {
                System.out.println(opp + "     " + reg1 + "     " + reg2 + "        ADD");
                System.out.println("                     Register R" + reg1);
                System.out.println("                     Register R" + reg2);
                ansVal = registers[reg1 - 1] + registers[reg2 - 1];
            } else if (cycleCnt == 3) {
                System.out.println(opp + "     " + reg1 + "     " + reg2 + "        ADD                  Register Updated");
                System.out.println("                     Register R" + reg1);
                System.out.println("                     Register R" + reg2);
                registers[reg1 - 1] = ansVal;
            }
            System.out.print("Register: ");
            printArray(registers);
            System.out.println();
            System.out.println("#################################################################");
            System.out.print("Memory: ");
            printArray(memory);
            System.out.println("\n\n");
            cycleCnt++;
        }
    }
}
