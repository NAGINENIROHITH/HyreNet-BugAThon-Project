package constants;

public class Constants {
    
    // Application URLs
    public static final String BASE_URL = "https://app.hyrenet.in/";
    public static final String LOGIN_URL = BASE_URL + "login";
    
    // Credentials
    public static final String TEST_EMAIL = "hyrenet+bugathon@guvi.in";
    public static final String TEST_PASSWORD = "hyrenettest@123";
    
    // Timeout values (in seconds)
    public static final int IMPLICIT_WAIT = 10;
    public static final int EXPLICIT_WAIT = 20;
    public static final int PAGE_LOAD_TIMEOUT = 30;
    
    // Screenshot settings
    public static final String SCREENSHOT_PATH = "test-output/screenshots/";
    
    // Report settings
    public static final String EXTENT_REPORT_PATH = "test-output/extent-reports/";
    public static final String EXTENT_REPORT_NAME = "HyreNet-BugReport.html";
    
    // Test data
    public static final String TEST_DATA_PATH = "src/test/resources/testdata/testdata.xlsx";
    
    // Error messages (expected)
    public static final String INVALID_CREDENTIALS_ERROR = "Invalid credentials";
    public static final String FIELD_REQUIRED_ERROR = "This field is required";
    public static final String INVALID_EMAIL_ERROR = "Please enter a valid email";
    
    // Success messages
    public static final String LOGIN_SUCCESS = "Successfully logged in";
    public static final String QUESTION_CREATED = "Question created successfully";
    public static final String TEMPLATE_CREATED = "Template created successfully";
    public static final String TEST_CREATED = "Test created successfully";
}
