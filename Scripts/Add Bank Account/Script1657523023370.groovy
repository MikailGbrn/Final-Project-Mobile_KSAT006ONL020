import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.callTestCase(findTestCase('MP-6 Gibran - TC_Login'), [('username') : 'fernanda', ('password') : 'YBT6FhrtTETCg+OT1kJeXg=='], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Add Account From Dashboard/Add Account from Account Page/btn_hamburger'), 0)

Mobile.tap(findTestObject('Add Account From Dashboard/Add Account from Account Page/btn_page_Account'), 0)

Mobile.tap(findTestObject('Add Account From Dashboard/Add Account from Account Page/btn_plus_addAccount'), 0)

Mobile.setText(findTestObject('Add Account From Dashboard/editText_accountName_dashboard'), accountname, 0)

Mobile.setText(findTestObject('Add Account From Dashboard/editText_InitBalance_dashboard'), initbalance, 0)

Mobile.tap(findTestObject('Add Account From Dashboard/btn_add_account_dashboard'), 0)

AppiumDriver<?> driver = MobileDriverFactory.getDriver()

def toast = driver.findElementByXPath('//android.widget.Toast[@text=\'Account successfully added\']')

println('Toast element: ' + toast)

if (toast == null) {
    KeywordUtil.markFailed('ERROR: Toast object not found!')
}

driver.terminateApp(GlobalVariable.url)

