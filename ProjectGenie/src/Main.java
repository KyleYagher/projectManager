// Imports Section //
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import static java.time.LocalDate.parse;

// Main Program Class //
public class Main {
    // Methods Section //
    public static String[] createProject(Partner partnerObj) {
        /*  Method to capture User inputs used for creating a Project object.

        Parameters: Partner Object / Used to complete some partner related fields.
        Returns:    String array   / used to initialize the Project Object.

        */
        Scanner userInput = new Scanner(System.in); // Create new scanner object

        // Capture Project object parameters //
        System.out.print("Enter project type: ");
        String projectType = userInput.nextLine(); // Project type

        System.out.print("Enter project start date (dd/mm/yyyy): "); // Date inputs will be changed to allow the
        String projectStart = (LocalDate.now().plusDays(5)).toString(); // user to enter future dates
        System.out.print("Enter project end date: "); // the code will then calculate the inputs and display them
        String projectEnd = (LocalDate.now().plusMonths(3)).toString(); // accordingly.

        String projectName = projectType + " " + partnerObj.partnerName; // Project name
        System.out.print("Enter project address: ");
        String projectAddress = userInput.nextLine();                   // Project address
        System.out.print("Enter project ERF: ");
        String projectErf = userInput.nextLine();                       // Project ERF
        System.out.print("Enter project fee: R");
        String projectFee = userInput.nextLine();                       // Project Fee

        return new String[]{projectName, projectType, projectAddress, projectErf,
                projectFee, projectStart, projectEnd, partnerObj.partnerName};  // Return String array of inputs

    }

    public static String[] createPartner() {
        /*  Method to capture User inputs used for creating a Partner object.

        Parameters: None
        Returns:    String array / used to initialize the Partner Object.

        */
        Scanner userInput = new Scanner(System.in); // Create scanner object

        String userChoice;  // Declare String variable

        // While Loop that that handles inputs for creating a partner object
        while (true) {

            System.out.println(" *   Each Project requires 3 Partners...\n" +
                    " *   1x Customer\t 1x Contractor\t1x Architect");
            System.out.print(" *   Would you like to create a partner now (Y/N)?");

            userChoice = userInput.nextLine();

            switch (userChoice.toLowerCase()) {

                case "y":

                    // Capture Partner object parameters //
                    System.out.print("Enter Partner Name: ");
                    String partnerName = userInput.nextLine();          // Partner Name
                    System.out.print("Enter partner type: ");
                    String partnerType = userInput.nextLine();          // Partner Type
                    System.out.print("Enter partner Address: ");
                    String partnerAddress = userInput.nextLine();       // Partner Address
                    System.out.print("Enter partner Email: ");
                    String partnerEmail = userInput.nextLine();         // Partner Email
                    System.out.print("Enter partner Telephone: ");
                    String partnerTel = userInput.nextLine();           // Partner Tel

                    return new String[]{partnerName, partnerType, partnerAddress, partnerEmail, partnerTel};

                case "n":

                    System.out.println("Returning to main menu!!");
                    break;

                default:

                    System.out.println("Incorrect Selection made! Please try again!!");
            }
        }
    }

    public static void generateInvoice(Project projectObj, Partner partnerObj) {
        /*  Method to generate an invoice for the selected project.

        Parameters:
                    Project Object / Used to populate the project related fields.
                    Partner Object / Used to populate the partner related fields.
        Returns:    None           / Displays the invoice to screen.

        */

        int randomNum = (int)(Math.random() * 10000);
        System.out.println("|---------------|- Invoice " + randomNum + " -|---------------|");
        System.out.println("| Project Name\t\t: " + projectObj.projectName);            // Partner Details
        System.out.println("| Customer Email\t: " + partnerObj.partnerEmail);
        System.out.println("| Customer Telephone: " + partnerObj.partnerTel);
        System.out.println("+-----------------------------+------------------+");
        System.out.println("| Project Fee\t: \t\t\t\t\t\t R " + projectObj.projectFee); // Billing Information
        System.out.println("| Balance Paid\t:\t\t\t - R " + projectObj.balanceReceived);
        System.out.println("                              +------------------+");
        System.out.println("| Balance C/f\t: \t\t\t\t\t\t R "
                + (projectObj.projectFee - projectObj.balanceReceived));                // Billing Total
        System.out.println("                              +------------------+");

    }

    public static void main(String[] args) {
        // Main Project Method //

        //Global variable declarations
        String[] project = new String[0];
        String[] partner = new String[0];
        Project projectObj = null;
        Partner partnerObj = null;
        Scanner userInput = new Scanner(System.in);
        int menuSelection;

        // Loop that handles Menu interface display and user inputs.
        do {

            System.out.println("+--------------+- Project Genie -+---------------+");
            System.out.println("|                 * Main Menu *                  |");
            System.out.print("|- 1. Start New Project \n");
            System.out.print("|- 2. Update Project Due Date \n");
            System.out.print("|- 3. Update Outstanding Balance \n");
            System.out.print("|- 4. Update Contractor contact info \n");
            System.out.print("|- 5. Finalize Project \n");
            System.out.print("|- 6. Exit \n");
            System.out.print("\nMake your selection: ");
            menuSelection = userInput.nextInt();    // User Menu input selection


            switch (menuSelection) {

                case 1:
                    /*
                    Logic for creating a new Project which requires a partner object to be created first.
                    Some if the logic in this section can be done more efficiently but for the moment it
                    meets task requirements.
                    */
                    partner = createPartner();
                    partnerObj = new Partner(partner[0], partner[1], partner[2], partner[3], partner[4]);
                    System.out.println("\n\n  <==<< New Partner successfully created! >>=>" + partnerObj);

                    project = createProject(partnerObj);
                    int projectId =  (int)(Math.random() * 10000);
                    int projectFee = Integer.parseInt(project[4]);
                    projectObj = new Project(projectId, project[0], project[1], project[2],
                            project[3], projectFee, project[5], project[6], project[7]);
                    System.out.println("\n\n  <==<< New Project successfully created! >>=>" + projectObj);

                    break;

                case 2:
                    // Logic to update the due date of a project. //
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/d");
                    assert projectObj != null;

                    // Adds one month to end  of project but will be adapted to accept user input declaration //
                    String date =  projectObj.projectEnd;
                    LocalDate dateobject = parse(date);
                    projectObj.projectEnd = dateobject.plusMonths(1).toString();
                    System.out.println(projectObj);
                    break;

                case 3:
                    // Logic to update balance paid by the customer. //
                    assert projectObj != null;
                    projectObj.balanceReceived = userInput.nextInt();
                    System.out.println(projectObj);
                    break;

                case 4:
                    // Logic to update customer contact information. //
                    assert partnerObj != null;
                    partnerObj.partnerEmail = "New Email";//userInput.nextLine();
                    partnerObj.partnerTel = "New Tel";//userInput.nextLine();
                    System.out.println(partnerObj);
                    break;

                case 5:
                    // Logic to update project finalization and invoice creation.
                    assert projectObj != null;
                    projectObj.projectFinalise = "Yes";
                    projectObj.dateCompleted = LocalDate.now();
                    int outstanding = projectObj.projectFee - projectObj.balanceReceived;

                    if (outstanding > 0) {

                        generateInvoice(projectObj, partnerObj);

                    }
                    break;

                case 6:
                    // Program exit //
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;

                default:

                    System.out.println(menuSelection + " Is an Invalid selection! Please try again!");

            }

        }while (menuSelection != 6);
    }
}







