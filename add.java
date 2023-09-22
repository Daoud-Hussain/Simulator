import java.util.Scanner;

public class add {
    static int[] registers = new int[10];
    static int[] memory = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter number of instructions to be executed: ");
        int count = scanner.nextInt();
        boolean flag = true;

        while (count > 0) {
            while (flag) {
                System.out.println("Enter Instruction type \n1. Add \n2. Exit: ");
                int instruction = scanner.nextInt();
                if (instruction == 1) {
                    System.out.print("Enter Register 1 Number: ");
                    int registerNo1 = scanner.nextInt();
                    System.out.print("Enter Register 2 Number: ");
                    int registerNo2 = scanner.nextInt();
                    add(instruction, registerNo1, registerNo2);
                    break;
                }
                else if(instruction == 2){
                    flag = false;
                }
                else{
                    System.out.println("Invalid Input");
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
