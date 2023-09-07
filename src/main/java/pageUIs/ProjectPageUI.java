package pageUIs;

public class ProjectPageUI {
    public static String addProjectBtn = "//button[normalize-space()='Add project']";
    public static String addProjectInPopupBtn = "(//button[normalize-space()='Add project'])[2]";
    public static String projectText = "//div[text()='Projects']";
    public static String projectNameTxt = "//label[text()='Project Name']/parent::div//input";
    public static String projectDescriptionTxt = "//label[text()='Project Description']/parent::div//textarea[@placeholder='Description']";
    public static String projectPurposeTxt = "//label[text()='Project Purpose']/parent::div//textarea[@placeholder='Purpose']";
    public static String successMsg = "//div[contains(@class,'MuiAlert-message')]/strong";
    public static String projectTitle = "//h5[contains(@class,'MuiTypography-h5') and text()='%s']";
    public static String projNameErrMsg = "//label[text()='Project Name']//parent::div//div[2]";
    public static String dupProjNameMsg = "//label[text()='Project Name']//preceding-sibling::p";
    public static String existProjectTitle = "(//p[contains(@class,'projectdate')]//preceding-sibling::h5)[1]";

}
