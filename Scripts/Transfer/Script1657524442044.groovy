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

Mobile.tap(findTestObject('Transfer/btn_transfer'), 0)

Mobile.tap(findTestObject('Transfer/btn_drop_sending'), 0)

Mobile.tap(findTestObject('Transfer/option_roni_send'), 1)

Mobile.setText(findTestObject('Transfer/editText_transfer-ammount'), amount, 0)

Mobile.tap(findTestObject('Transfer/btn_drop_recieving'), 0)

Mobile.tap(findTestObject('Transfer/option_joni_recieve'), 2, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Transfer/btn_confirm-transfer'), 0)

AppiumDriver<?> driver = MobileDriverFactory.getDriver()

def toast = driver.findElementByXPath('//android.widget.Toast[1]')

String text = toast.getAttribute('name')

if (text == (('Transfer of $' + amount) + ' successfully made')) {
    Mobile.closeApplication()
}

println('Toast element: ' + toast)

if (toast == null) {
    KeywordUtil.markFailed('ERROR: Toast object not found!')
}

driver.terminateApp(GlobalVariable.url)

