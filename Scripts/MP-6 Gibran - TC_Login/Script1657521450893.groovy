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

CucumberKW.runFeatureFile('Include/features/MP-6 Gibran - TC_Login.feature')

Mobile.startExistingApplication(GlobalVariable.url)

Mobile.clearText(findTestObject('Login/editText_Uname_login'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('Login/editText_Uname_login'), username, 0)

Mobile.clearText(findTestObject('Login/editText_Password_login'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.setEncryptedText(findTestObject('Login/editText_Password_login'), password, 0)

Mobile.tap(findTestObject('Login/btn_Login'), 0)

Mobile.verifyElementExist(findTestObject('Login/Dashboard Header'), 0)

