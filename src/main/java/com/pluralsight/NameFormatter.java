package com.pluralsight;

public class NameFormatter {

    //* Private constructor so NameFormatter instance cannot be  created.
    private NameFormatter() {
    }

    public static String format(String firstName, String lastName) {
        return lastName + ", "  + firstName;
    }

    public static String format (String prefix, String firstName, String middleName, String lastName, String suffix) {
        //! Always here
        String fivePartFormat = lastName + ", ";
        //! if prefix is not null, and it's not empty, then we're gonna add it to the formatted String.
        if (prefix != null && !prefix.isEmpty()) {
            fivePartFormat += prefix + " ";
        }
        //! Always here
        fivePartFormat += firstName;
        //! if middleName is not null, and it's not empty, then we're gonna add it to the formatted String.
        if (middleName != null && !middleName.isEmpty()) {
            fivePartFormat += " " + middleName;
        }
        //! if suffix is not null, and it's not empty, then we're gonna add it to the formatted String.
        if (suffix != null && !suffix.isEmpty()) {
            fivePartFormat += ", " + suffix;
        }
        return fivePartFormat;
    }

    public static String format(String fullName) {
        String prefix = "", firstName = "", middleName = "", lastName = "", suffix = "";

        String[] namePieces = fullName.split(",");
        if (namePieces.length == 2) {
            suffix = namePieces[1].trim();
        } else {
            suffix = "";
        }
        String [] words = namePieces[0].trim().split(" ");
        switch (words.length) {
            case 2:
                firstName = words[0].trim();
                lastName = words[1].trim();
                break;
            case 3:
                if (words[0].endsWith(".")) {
                    prefix = words[0].trim();
                    firstName = words[1].trim();
                    lastName = words[2].trim();
                } else {
                    firstName = words[0].trim();
                    middleName = words[1].trim();
                    lastName = words[2].trim();
                }
                break;
            case 4:
                prefix = words[0].trim();
                firstName = words[1].trim();
                middleName = words[2].trim();
                lastName = words[3].trim();
                break;
        }
        return format(prefix, firstName, middleName, lastName, suffix);
    }

    //! lastName, prefix. firstName middleName, suffix
//*    You should assume that an incoming fullName will always come formatted in this order:
//    Prefix FirstName MiddleName LastName, Suffix
//    Dr. Mel B Johnson, PhD
//    Mel B Johnson, PhD
//    Mel Johnson

}
