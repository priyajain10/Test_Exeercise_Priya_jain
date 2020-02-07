package com.bnkbl.stepdefs;

import com.bnkbl.UserRepository;
import com.bnkbl.sut.SimpleUserRepository;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
//import sun.tools.jconsole.JConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UsersStepDefs {


    // This is the System Under Test Do NOT modify the SIT.
    private UserRepository repository = new SimpleUserRepository();
    List<String> Ids = new ArrayList<String>();
    List<String >UserNames = new ArrayList<String>();



    @Given("I create users with name and age as follows")
    public void i_create_a_user_with_name_and_age_as_follows(DataTable dataTable) {

        List<Map<String, String>> data =  dataTable.asMaps();
        for ( int i = 0; i < data.size(); i++)
        {


            String Name = data.get(i).get("Name");
            String temp = data.get(i).get("Age");
            int Age = Integer.parseInt(temp);
            String id = repository.createUser(Name, Age);
            Ids.add(id);


        }

    }

    @When("I use the returned IDs to search for the users")
    public void i_search_by_their_IDs() {

        for ( int l  = 0; l < Ids.size(); l++)
        {
            String Name = repository.getNameById(Ids.get(l));
            UserNames.add(Name);

        }


    }

    @Then("I will see that the users name is as follows")
    public void i_will_see_that_the_users_name_is_as_follows(DataTable dataTable) {

        List<Map<String, String>> data =  dataTable.asMaps();

        for (int j = 0; j < data.size(); j++)
        {
            String Name = data.get(j).get("Name");
            Assert.assertEquals(Name, UserNames.get(j));

        }


    }

}
