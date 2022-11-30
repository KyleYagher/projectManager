import java.time.LocalDate;
public class Project {

    // Attributes //
    Integer projectId;
    String projectName;
    String projectType;
    String projectAddress;
    String projectErf;
    Integer projectFee;
    Integer balanceReceived;
    String projectStart;
    String projectEnd;
    String projectCustomer;
    String projectContractor;
    String projectArchitect;
    String projectFinalise;
    LocalDate dateCompleted;

    // Methods //
    public Project (Integer projectId, String projectName, String projectType, String projectAddress, String projectErf,
                    Integer projectFee, String projectStart, String projectEnd, String projectCustomer) {

        this.projectId = projectId;
        this.projectName = projectName;
        this.projectType = projectType;
        this.projectAddress = projectAddress;
        this.projectErf = projectErf;
        this.projectFee = projectFee;
        this.balanceReceived = 0;
        this.projectStart = projectStart;
        this.projectEnd = projectEnd;
        this.projectCustomer = projectCustomer;
        this.projectContractor = "";
        this.projectArchitect = "";
        this.projectFinalise = "No";
        this.dateCompleted = null;


    }

    public String toString() {

        String output = "\n+-----------------|* Details *|------------------+";
        output += "\n| Project ID:" + projectId;
        output += "\n| Project Name: " + projectName;
        output += "\n| Project Type: " + projectType;
        output += "\n| Project Address: " + projectAddress;
        output += "\n| Project Erf: " + projectErf;
        output += "\n+-----------------|* Timeline *|-----------------+";
        output += "\n| Project Start: " + projectStart;
        output += "\n| Project End: " + projectEnd;
        output += "\n| Project Finalised: " + projectFinalise;
        output += "\n| Date Completed: " + dateCompleted;
        output += "\n+-----------------|* Partners *|-----------------+";
        output += "\n| Project Customer: " + projectCustomer;
        output += "\n| Project Architect: " + projectArchitect;
        output += "\n| Project Contractor: " + projectContractor;
        output += "\n+-----------------|* Billing *|------------------+";
        output += "\n| Project Fee: R" + projectFee;
        output += "\n| Balance received: R" + balanceReceived;
        output += "\n| Balance Outstanding: R" + (projectFee - balanceReceived);
        output += "\n+------------------------------------------------+\n";

        return output;
    }
}
