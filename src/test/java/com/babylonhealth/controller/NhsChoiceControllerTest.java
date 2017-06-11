package com.babylonhealth.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URLEncoder;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class NhsChoiceControllerTest {

  @Autowired private MockMvc mockMvc;

  @Autowired private TestRestTemplate restTemplate;

  @Ignore
  @Test
  public void testAskQuestion() throws Exception {

    String question = URLEncoder.encode("What are the symptoms of cancer ?", "UTF-8");
    String request = String.format("/nhsChoice/question/%s", question);
    this.mockMvc.perform(get(request)).andExpect(status().isOk());
  }

  @Test
  public void testFindByContent() throws Exception {

    String question = URLEncoder.encode("colic", "UTF-8");
    String request = String.format("/nhsChoice/content/%s", question);
    this.mockMvc
        .perform(get(request))
        .andExpect(
            content()
                .string(
                    "[ \"http://www.nhs.uk/Conditions/Colic/Pages/clinical-trial-details.aspx?TrialId=NCT03105440&Condition=Colic&pn=609&Rec=0&CT=0\"]"))
        .andExpect(status().isOk());
  }
}
