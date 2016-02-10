package stack.overflow.test.first;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Pankaj Nimgade on 10-02-2016.
 */
public class ReadJSON {

    public static void main(String[] args) {

        try {
            String text = FileUtils.readFileToString(new File("file.txt"));

            ArrayList<Identity> identities = new ArrayList<>();

            Response responseread = getResponseObject(text, Response.class);

            System.out.println(responseread.isResultCode());

            for (int i = 0; i < 2; i++) {
                Identity identity = new Identity();
                identity.setFirstName("First");
                identity.setLastName("Last");
                identity.setGender("Male");
                identity.setDateOfBirth("1/2/5");
                identities.add(identity);
            }

            IdentityList identityList = new IdentityList();
            identityList.setIdentities(identities);

            User user = new User();
            user.setIdentities(identityList);


            Response response = new Response();
            response.setUser(user);
            response.setResultCode(true);

//            System.out.println((new Gson()).toJson(response));



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static <T> T getResponseObject(String resourceResponse, Class<T> responseClass) {
        T responseObject = null;

        if (responseObject == Response.class) {
//            responseObject = (new Gson()).fromJson(resourceResponse,  Response.class);
        }

        return responseObject;
    }
}

class Response {

    @SerializedName("User")
    private User user;

    @SerializedName("resultCode")
    private boolean resultCode;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isResultCode() {
        return resultCode;
    }

    public void setResultCode(boolean resultCode) {
        this.resultCode = resultCode;
    }
}

class User {

    @SerializedName("identityList")
    IdentityList identities;

    public IdentityList getIdentities() {
        return identities;
    }

    public void setIdentities(IdentityList identities) {
        this.identities = identities;
    }
}

class IdentityList {

    @SerializedName("identity")
    ArrayList<Identity> identities;

    public ArrayList<Identity> getIdentities() {
        return identities;
    }

    public void setIdentities(ArrayList<Identity> identities) {
        this.identities = identities;
    }
}

class Identity {

    @SerializedName("firstName")
    private String firstName;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("gender")
    private String gender;
    @SerializedName("dateOfBirth")
    private String dateOfBirth;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}


