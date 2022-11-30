import java.util.Scanner;
public class Partner {

    // Attributes //
    String partnerName;
    String partnerType;
    String partnerAddress;
    String partnerEmail;
    String partnerTel;

    // Methods //
    public Partner(String partnerName, String partnerType, String partnerAddress,
                   String partnerEmail, String partnerTel ) {

        this.partnerName = partnerName;
        this.partnerType = partnerType;
        this.partnerAddress = partnerAddress;
        this.partnerEmail = partnerEmail;
        this.partnerTel = partnerTel;

    }

    public String toString() {
        String output = "\n+------------------------------------------------+";
        output += "\n| Partner Name: " + partnerName;
        output += "\n| Partner Type: " + partnerType;
        output += "\n| Partner Address: " + partnerAddress;
        output += "\n| Partner Email: " + partnerEmail;
        output += "\n| Partner Tel: " + partnerTel;
        output += "\n+------------------------------------------------+";

        return output;
    }

}
