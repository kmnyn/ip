public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.out.println("____________________________________________________________");
        System.out.println("Bye. See ya!");
        System.out.println("____________________________________________________________");
        System.exit(0);  // Terminates the program
    }
}
