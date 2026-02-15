import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int counter =0;
        String name = "";
        String[] users = new String[100];
        boolean control = true;
        int number;

        printMessage();

        while(control){
            dashboard();
            number = sc.nextInt();
            sc.nextLine();
            control = choices(number);
            if (number==1){
                name = sc.nextLine();
               counter = users(counter,name,users);
            } if(counter >=100){
               control = counter();
            }
            if(number==2){
                listUsers(counter, users);
            }
            else if (number==3){
                name = sc.nextLine();
                removeUsers(name, counter, users);
            }

        }

        sc.close();
    }

    public static void printMessage(){
        System.out.println("============================");
        System.out.println("Welcome to the user systems!");
        System.out.println("============================");
    }

    public static void dashboard(){
        System.out.println("What do you want to do?");
        System.out.println("1 - Register user");
        System.out.println("2 - List users");
        System.out.println("3 - Remove user");
        System.out.println("4 - Exit");
    }

    public static boolean choices(int number){
        boolean control = true;
        switch (number){
            case 1:
                System.out.println("Attention! The system supports up to 100 users.");
                System.out.println("What is your name?");
                break;
            case 2:
                System.out.println("List of users:");
                break;
            case 3:
                System.out.println("Which user do you want to remove?");
                break;
            case 4:
                System.out.println("Leaving...");
                control = false;
                break;
        }
        return control;
    }

    public static int users(int counter, String name, String[] users){
        users[counter] = name;
        counter++;

        return counter;
    }

    public static boolean counter(){
        boolean control = true;
        System.out.println("Registration is no longer possible!");
        control = false;

        return control;
    }

    public static void listUsers(int counter, String[] users){
        for (int i=0; i<counter; i++){
            System.out.printf("%d - %s, \n",i,users[i]);
        }
    }

    public static void removeUsers(String name,int counter, String[] users){
        boolean remove = false;
        int auxiliaryVariable=0;
        String[] users2 = new String[100];
        for (int i=0; i<counter; i++){
            if (name.equals(users[i])) {
                auxiliaryVariable = i;
                remove = true;
                break;
            }
        }
        if (remove){
            users[auxiliaryVariable] ="User removed";
        }
    }
}