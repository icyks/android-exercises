package fr.android.androidexercises;

import org.assertj.android.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

@RunWith(CustomRobolectricTestRunner.class)
public class JUnitLoginActivityTest {
    LoginActivity activity;

    @Before
    public void setUp() throws Exception{
        activity = Robolectric.setupActivity(LoginActivity.class);
    }

    @Test
    public void should_set_logged_state() throws Exception {
        activity.logged();
        Assertions.assertThat(activity.loggedText).isVisible();
        Assertions.assertThat(activity.loginLayout).isGone();
    }

    @Test
    public void should_set_not_logged_state() throws Exception {
        activity.onResume();
        Assertions.assertThat(activity.loggedText).isGone();
        Assertions.assertThat(activity.loginLayout).isVisible();
    }

    @Test
    public void message() throws Exception {
        activity.message(1);
        Assertions.assertThat(activity.loggedText).isGone();
    }


}