package tw.com.pcschool.dd2018020803;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    JobScheduler jobScheduler;
    JobInfo jobInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        JobInfo.Builder builder = new JobInfo.Builder( 1,
                new ComponentName(getPackageName(),
                        MyJobService.class.getName() ) );
        builder.setPeriodic(3000);
        jobInfo = builder.build();
    }
    public void click1(View v)
    {
        jobScheduler.schedule(jobInfo);
    }
    public void click2(View v)
    {
        jobScheduler.cancel(1);
    }
}
