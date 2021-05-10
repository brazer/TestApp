package com.salanevich.testapp.ui.activity

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.salanevich.testapp.ui.activity.screen.DetailsScreen
import com.salanevich.testapp.ui.activity.screen.Item
import com.salanevich.testapp.ui.activity.screen.ListScreen
import org.junit.Rule
import org.junit.Test

class MainActivityTest: TestCase() {

    @Rule
    @JvmField
    val activityRule = ActivityScenarioRule(ItemDetailHostActivity::class.java)
    private val mainScreen = ListScreen()
    private val detailsScreen = DetailsScreen()

    @Test
    fun smokeTest() {
        before {  }.after {  }
            .run {
                step("Test main screen") {
                    mainScreen {
                      recycler {
                          val lastIndex = 52
                          for (i in 0..lastIndex) {
                              scrollTo(i)
                              childAt<Item>(i) {
                                  title.hasAnyText()
                                  if (i == lastIndex) {
                                      click()
                                  }
                              }
                          }
                      }
                    }
                }
                step("Test details screen") {
                    detailsScreen {
                        title.hasAnyText()
                        Thread.sleep(10_000)
                        image.isDisplayed()
                    }
                }
            }
    }

}