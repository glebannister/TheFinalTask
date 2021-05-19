package test;

import app.api.addAttachmentTestRail.AttachmentRequest;
import app.api.addAttachmentTestRail.AttachmentResponse;
import app.api.addCaseTestRail.Case;
import app.api.addCaseTestRail.CaseResponse;
import app.api.addCaseTestRail.TestCaseRequest;
import app.api.addResultTestRail.Result;
import app.api.addResultTestRail.ResultRequest;
import app.api.addResultTestRail.ResultResponse;
import app.api.addRunTestRail.Run;
import app.api.addRunTestRail.RunRequest;
import app.api.addRunTestRail.RunResponse;
import app.api.addSectionTestRail.Section;
import app.api.addSectionTestRail.SectionRequest;
import app.api.addSectionTestRail.SectionResponse;
import app.api.addSuiteTestRail.Suite;
import app.api.addSuiteTestRail.SuiteRequest;
import app.api.addSuiteTestRail.SuiteResponse;
import app.api.constants.RequestHeaderConstants;
import app.api.enums.*;
import app.api.getNexageTests.Tests;
import app.api.getNexageTests.TestsGetXmlRequest;
import app.api.getNexageTests.TestsResponseNexage;
import app.api.getTestTestRail.TestsRequest;
import app.api.getTestTestRail.TestsResponse;
import app.api.getToken.Token;
import app.api.getToken.TokenRequest;
import app.api.getToken.TokenResponse;
import app.ui.constants.RegularExpression;
import app.ui.constants.TextConstants;
import app.ui.enums.TestStatus;
import app.ui.models.NewTest;
import app.ui.pages.*;
import framework.browser.Browser;
import framework.utils.*;
import framework.waits.Waits;
import org.apache.hc.core5.http.HttpStatus;
import org.testng.Assert;
import java.nio.file.Paths;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TheFinalTaskVariant2 {

    @Test
    public void theFinalTaskVariant2() {
        Waits.implicitWait();
        LogUtil.step(1, "With api request generate token with number of variant");
        Token token = new Token();
        token.setVariant(PropertyReader.getDataValue("taskVariant"));
        TokenResponse getTokenResponse = TokenRequest.getToken(token);
        Assert.assertEquals(
                getTokenResponse.getStatusCode(),
                HttpStatus.SC_OK,
                String.format("Code are not match %s %s", getTokenResponse.getStatusCode(), HttpStatus.SC_OK));
        Assert.assertNotNull(getTokenResponse.getToken(), "Token was not generated");

        LogUtil.step(2, "Go to site. Pass authorization. With cookie transfer token. Refresh page");
        Browser.maximizeWindow();
        LogUtil.info(String.format("Go to %s", StringUtil.baseAuthUrl()));
        Browser.moveTo(StringUtil.baseAuthUrl());
        String projectsWindow = Browser.getWindowHandler();
        ProjectsPage projectsPage = new ProjectsPage();
        Assert.assertTrue(projectsPage.isPageLoaded(), "Projects page was not loaded");
        String tokenValue = getTokenResponse.getToken();
        Browser.addCookie(PropertyReader.getDataValue("cookieName"), tokenValue);
        Browser.refreshPage();
        Assert.assertEquals(
                projectsPage.getVersion(),
                PropertyReader.getDataValue("correctVersion"),
                String.format(
                        "Versions are not match %s%s",
                        projectsPage.getVersion(),
                        PropertyReader.getConfigValue("correctVersion")));

        LogUtil.step(
                3, "Go to project Nexage page. With api request get list of tests in XML format");
        projectsPage.getProjectsListForm().selectProjectByName(PropertyReader.getDataValue("projectNameNexage"));
        NexageProjectPage nexageProjectPage = new NexageProjectPage();
        Assert.assertEquals(
                nexageProjectPage.getProjectName(),
                (PropertyReader.getDataValue("projectNameNexage")),
                String.format("Test name is not correct %s %s",
                        nexageProjectPage.getProjectName(), (PropertyReader.getDataValue("projectNameNexage"))));
        Tests test = new Tests();
        test.setProjectId(PropertyReader.getAppApiValue("projectId"));
        TestsResponseNexage testsResponseNexage = TestsGetXmlRequest.getTestsXml(test);
        Assert.assertEquals(
                testsResponseNexage.getStatusCode(),
                HttpStatus.SC_OK,
                String.format("Code are not match %s %s", testsResponseNexage.getStatusCode(), HttpStatus.SC_OK));
        Assert.assertTrue(
                testsResponseNexage.getContentType().contains(RequestHeaderConstants.HEADER_VALUE_APPLICATION_XML),
                "Response was not in correct format");
        Assert.assertTrue(
                nexageProjectPage.isTestOnPageAreInApiResponse(testsResponseNexage.getTests()),
                "Tests on page are not in api response");
        Assert.assertTrue(
                nexageProjectPage.isTestsSortedByDescendingDate(), "Tests are not sorted by descending date");

        LogUtil.step(
                4, "Back to projects page. Click on Add+. Create new project. Close current window" +
                        " and back to previous page. Refresh page");
        nexageProjectPage.clickHomeButton();
        Assert.assertTrue(projectsPage.isPageLoaded(), "Projects page was not loaded");
        projectsPage.clickAddProjectButton();
        Browser.switchToAnotherWindow(projectsWindow);
        AddProjectPage addProjectPage = new AddProjectPage();
        Assert.assertTrue(addProjectPage.isPageLoaded(), "Add project page was not loaded");
        String newProjectName = RandomUtil.getLatinRandomString(TextConstants.LENGTH_OF_TEXT);
        addProjectPage.getAddProjectForm().createNewProject(newProjectName);
        Assert.assertTrue(
                addProjectPage.isProjectSavedAlertAppeared(newProjectName),
                "Save project alert was not appeared or correct");
        String addProjectWindow = Browser.getWindowHandler();
        Assert.assertTrue(Browser.closeCurrentWindow(addProjectWindow), "Add project window was not closed");
        Browser.switchToProjectsWindow(projectsWindow);
        Browser.refreshPage();
        Assert.assertTrue(
                projectsPage.getProjectsListForm().isNewProjectAppeared(newProjectName),
                "New project was not saved");

        LogUtil.step(
                5,
                "Go to the page of the created project. Click on + Add. Fill in the required fields and" +
                        "attach a screenshot of the current page. Save the test. To close the pop-up, click outside " +
                        "its window");
        projectsPage.getProjectsListForm().selectProjectByName(newProjectName);
        NewProjectPage newProjectPage = new NewProjectPage();
        Assert.assertTrue(newProjectPage.isPageLoaded(), "New project page was not loaded");
        newProjectPage.getProjectPanelForm().clickAddTestButton();
        NewTest newTest = new NewTest(
                RandomUtil.getLatinRandomString(TextConstants.LENGTH_OF_TEXT),
                TestStatus.PASSED.getTestStatus(),
                RandomUtil.getLatinRandomString(TextConstants.LENGTH_OF_TEXT),
                DateUtil.getCurrentDate(PropertyReader.getDataValue("datePattern")),
                DateUtil.getCurrentDate(PropertyReader.getDataValue("datePattern")),
                RandomUtil.getLatinRandomString(TextConstants.LENGTH_OF_TEXT),
                RandomUtil.getLatinRandomString(TextConstants.LENGTH_OF_TEXT),
                StringUtil.pathToScreenshot(PropertyReader.getDataValue("screenshotName")));
        newProjectPage.getAddTestForm().createNewTest(newTest);
        Assert.assertTrue(
                newProjectPage.getAddTestForm().isNewTestSavedMessageAppeared(newTest.getName()),
                "New test saved message was not appeared or correct");
        newProjectPage.getAddTestForm().closeAddNewTestForm();
        Assert.assertTrue(
                newProjectPage.getTestsListForm().isNewTestAppeared(newTest.getName()),
                "New test was not appeared in list");

        LogUtil.step(
                6, "Go to the page of the created test. Check the correctness of the information");
        newProjectPage.getTestsListForm().selectTestByName(newTest.getName());
        NewTestPage newTestPage = new NewTestPage();
        Assert.assertTrue(newTestPage.isPageLoaded(), "New test page was not loaded");
        Assert.assertEquals(
                newTestPage.getTestName(),
                newTest.getName(),
                String.format("New test name is not correct %s %s",
                        newTestPage.getTestName(), newTest.getName()));
        Assert.assertTrue(newTestPage.getTestInfoForm().isFieldFilledCorrect(
                newProjectName), "Project name is not filled correct");
        Assert.assertTrue(
                newTestPage.getTestInfoForm().isFieldFilledCorrect(newTest.getName()),
                "Test name is not filled correct");
        Assert.assertTrue(
                newTestPage.getTestInfoForm().isFieldFilledCorrect(newTest.getMethod()),
                "Test method is not filled correct");
        Assert.assertTrue(
                newTestPage.getTestInfoForm().isFieldFilledCorrect(StringUtil.testStatusForChecking(
                        newTest.getStatus())), "Test status is not filled correct");
        Assert.assertTrue(
                newTestPage.getTestInfoForm().isFieldFilledCorrect(newTest.getEnvironment()),
                "Environment is not filled correct");
        Assert.assertTrue(
                newTestPage.getTestInfoForm().isFieldFilledCorrect(newTest.getBrowser()),
                "Browser is not filled correct");
        Assert.assertEquals(
                StringUtil.substringBase64WithRegular(
                        newTestPage.getScreenshotImageBase64(), RegularExpression.BASE64_START),
                FileUtil.getBase64(newTest.getPathToScreenshot()),
                "Screenshot image is not correct");
    }

    @AfterMethod
    public void closeDriver() {
//        LogUtil.step(7, "TestRail integration");
//        String pathToScreenshotTestRail = StringUtil.pathToScreenshot(
//                PropertyReader.getDataValue("screenshotNameTestRail"));
//        Browser.makeScreenshot(pathToScreenshotTestRail);
//        String loginTestRail = PropertyReader.getTestRailValue("loginTestRail");
//        String passwordTestRail = PropertyReader.getTestRailValue("passwordTestRail");
//        Suite suite = new Suite();
//        suite.setName(PropertyReader.getDataValue("suiteName"));
//        suite.setDescription(PropertyReader.getDataValue("suiteDescription"));
//        SuiteResponse suiteResponse = SuiteRequest.sendPost(suite, loginTestRail, passwordTestRail);
//        Assert.assertEquals(
//                suiteResponse.getStatusCode(),
//                HttpStatus.SC_OK,
//                String.format("Codes are not match %s %s", suiteResponse.getStatusCode(), HttpStatus.SC_OK));
//        Section section = new Section();
//        section.setDescription(PropertyReader.getDataValue("sectionDescription"));
//        section.setSuiteId(suiteResponse.getSuite().getId());
//        section.setParentId(null);
//        section.setName(PropertyReader.getDataValue("sectionName"));
//        SectionResponse sectionResponse = SectionRequest.sendPost(section, loginTestRail, passwordTestRail);
//        Assert.assertEquals(
//                sectionResponse.getStatusCode(),
//                HttpStatus.SC_OK,
//                String.format("Codes are not match %s %s", sectionResponse.getStatusCode(), HttpStatus.SC_OK));
//        Case testCase = new Case();
//        testCase.setTitle(PropertyReader.getDataValue("testCaseTitle"));
//        testCase.setTemplateId(TestCaseTemplateIdEnum.TEST_CASE.getValueOfTemplate());
//        testCase.setTypeId(TestCaseTypeEnum.FUNCTIONALITY.getValueOfType());
//        testCase.setPriorityId(TestCasePriorityEnum.MUST_TEST_1.getValueOfPriority());
//        testCase.setRefs(PropertyReader.getDataValue("reference"));
//        CaseResponse caseResponse = TestCaseRequest.sendPost(
//                sectionResponse.getSection().getId(),
//                testCase,
//                loginTestRail,
//                passwordTestRail);
//        Assert.assertEquals(
//                caseResponse.getStatusCode(),
//                HttpStatus.SC_OK,
//                String.format("Codes are not match %s %s", caseResponse.getStatusCode(), HttpStatus.SC_OK));
//        Run run = new Run();
//        run.setSuiteId(suiteResponse.getSuite().getId());
//        run.setName(PropertyReader.getDataValue("runName"));
//        run.setDescription(PropertyReader.getDataValue("runDescription"));
//        run.setAssignedtoId(RunAssignedToEnum.ME.getValueOfAssignedTo());
//        run.setIncludeAll(true);
//        run.setRefs(PropertyReader.getDataValue("reference"));
//        RunResponse runResponse = RunRequest.sendPost(run, loginTestRail, passwordTestRail);
//        Assert.assertEquals(
//                runResponse.getStatusCode(),
//                HttpStatus.SC_OK,
//                String.format("Codes are not match %s %s", runResponse.getStatusCode(), HttpStatus.SC_OK));
//        TestsResponse testsResponse = TestsRequest.getTests(
//                runResponse.getRun().getId(), loginTestRail, passwordTestRail);
//        Assert.assertEquals(
//                testsResponse.getStatusCode(),
//                HttpStatus.SC_OK,
//                String.format("Codes are not match %s %s", testsResponse.getStatusCode(), HttpStatus.SC_OK));
//        Result result = new Result();
//        result.setStatusId(ResultStatusIdEnum.PASSED.getValueOfStatus());
//        result.setComment(PropertyReader.getDataValue("resultComment"));
//        result.setVersion(PropertyReader.getDataValue("resultVersion"));
//        result.setDefects(PropertyReader.getDataValue("resultDefects"));
//        result.setAssignedtoId(Integer.parseInt(PropertyReader.getDataValue("myId")));
//        ResultResponse resultResponse = ResultRequest.sendPost(
//                testsResponse
//                        .getTests()
//                        .get(Integer.parseInt(PropertyReader.getDataValue("indexOfAddedTest")))
//                        .getId(),
//                result,
//                loginTestRail,
//                passwordTestRail);
//        Assert.assertEquals(
//                resultResponse.getStatusCode(),
//                HttpStatus.SC_OK,
//                String.format("Codes are not match %s %s", resultResponse.getStatusCode(), HttpStatus.SC_OK));
//        AttachmentResponse attachmentResponse = AttachmentRequest.sendPost(
//                resultResponse.getResult().getId(),
//                loginTestRail,
//                passwordTestRail,
//                Paths.get(pathToScreenshotTestRail));
//        Assert.assertEquals(
//                attachmentResponse.getStatusCode(),
//                HttpStatus.SC_OK,
//                String.format("Codes are not match %s %s", attachmentResponse.getStatusCode(), HttpStatus.SC_OK));
//        LogUtil.info("Close browser");
        Browser.quitBrowser();
    }
}
