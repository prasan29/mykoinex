package in.koinex.mykoinex.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import in.koinex.mykoinex.POJO.KoinexJSON;
import in.koinex.mykoinex.POJO.Stats;
import in.koinex.mykoinex.R;
import in.koinex.mykoinex.api.APIUtil;
import in.koinex.mykoinex.iAPIInterface;
import in.koinex.mykoinex.util.SharedPrefs;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    public static final int INTERVAL = 1000 * 60 * 30;
    static Stats overallResult;
    boolean isAppOpen;
    ImageView refreshIcon;
    TextView contentText;
    Switch notifySwitch;
    Handler handler;
    private ProgressDialog progress;
    Runnable mHandlerTask = new Runnable() {
        @Override
        public void run() {
            if (isAppOpen) {
                hitAPI();
                Toast.makeText(HomeActivity.this, "Chart updated!", Toast.LENGTH_SHORT).show();
            } else {
                //Notification
            }
            handler.postDelayed(mHandlerTask, INTERVAL);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();

        if (SharedPrefs.getInstance().getNotification()) {
            notifySwitch.setChecked(true);
        } else {
            notifySwitch.setChecked(false);
        }
        hitAPI();
    }

    private void init() {
        SharedPrefs.getInstance().initSharedPrefs(this);
        handler = new Handler();

        refreshIcon = (ImageView) findViewById(R.id.refreshIcon);
        contentText = (TextView) findViewById(R.id.contentText);
        notifySwitch = (Switch) findViewById(R.id.notificationSwitch);

        progress = new ProgressDialog(this);
        progress.setMessage("Loading...");

        refreshIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitAPI();
            }
        });

        notifySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                SharedPrefs.getInstance().setNotification(b);
                runAsync();
            }
        });
    }

    /*private void hitAPIAsync() {
        new AsyncTask<Void, Void, String>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                Log.e("RESPONSE", "onPreExecute");
            }

            @Override
            protected String doInBackground(Void... voids) {
                hitAPI();
                return "";
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if (overallResult != null) {
//                    processStats(overallResult);
                    Log.e("RESPONSE", "onPostExecute");
//                    Toast.makeText(HomeActivity.this, overallResult.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }.execute();
    }*/

    private void hitAPI() {
        progress.show();
        iAPIInterface iapiInterface = APIUtil.getClient().create(iAPIInterface.class);
        Call<KoinexJSON> call = iapiInterface.getResponse();
        call.enqueue(new Callback<KoinexJSON>() {
            @Override
            public void onResponse(Call<KoinexJSON> call, Response<KoinexJSON> response) {
                try {
//                    Toast.makeText(HomeActivity.this, "", Toast.LENGTH_SHORT).show();
                    processStats(response.body().getStats());
                    progress.dismiss();
/*
                    if (response.body() != null) {
//                        Log.e("RESPONSE", response.body().toString());
//                        overallResult = response.body().getStats();
//                        Toast.makeText(HomeActivity.this, overallResult, Toast.LENGTH_SHORT).show();
//                        Toast.makeText(HomeActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
//                        Stats stats = response.body().getStats();
                        processStats(response.body().getStats());
                        progress.dismiss();
                    } else {
                        Toast.makeText(HomeActivity.this, "Unexpected error!", Toast.LENGTH_SHORT).show();
                        progress.dismiss();
                    }
*/
                } catch (Exception e) {
                    Toast.makeText(HomeActivity.this, "Refreshed too many times! Check after 10 mins!!", Toast.LENGTH_LONG).show();
                    progress.dismiss();
                }
            }

            @Override
            public void onFailure(Call<KoinexJSON> call, Throwable t) {
                Toast.makeText(HomeActivity.this, "Connection error!", Toast.LENGTH_SHORT).show();
                progress.dismiss();
            }
        });
    }

    private void processStats(Stats stats) {
        if (isAppOpen) {
            /*((TextView) findViewById(R.id.ethId))
                    .setText("ETH   " + stats.getETH().getLast_traded_price() + "  " + stats.getETH().getMin_24hrs() + "  " + stats.getETH().getMax_24hrs());
            ((TextView) findViewById(R.id.btcId))
                    .setText("BTC   " + stats.getBTC().getLast_traded_price() + "  " + stats.getBTC().getMin_24hrs() + "  " + stats.getBTC().getMax_24hrs());
            ((TextView) findViewById(R.id.ltcId))
                    .setText("LTC   " + stats.getLTC().getLast_traded_price() + "  " + stats.getLTC().getMin_24hrs() + "  " + stats.getLTC().getMax_24hrs());
            ((TextView) findViewById(R.id.xrpId))
                    .setText("XRP   " + stats.getXRP().getLast_traded_price() + "  " + stats.getXRP().getMin_24hrs() + "  " + stats.getXRP().getMax_24hrs());
            ((TextView) findViewById(R.id.bchId))
                    .setText("BCH   " + stats.getBCH().getLast_traded_price() + "  " + stats.getBCH().getMin_24hrs() + "  " + stats.getBCH().getMax_24hrs());*/

            getTextView(R.id.ethLastId).setText(stats.getETH().getLast_traded_price());
            getTextView(R.id.ethMinId).setText(stats.getETH().getMin_24hrs());
            getTextView(R.id.ethMaxId).setText(stats.getETH().getMax_24hrs());

            getTextView(R.id.btcLastId).setText(stats.getBTC().getLast_traded_price());
            getTextView(R.id.btcMinId).setText(stats.getBTC().getMin_24hrs());
            getTextView(R.id.btcMaxId).setText(stats.getBTC().getMax_24hrs());

            getTextView(R.id.ltcLastId).setText(stats.getLTC().getLast_traded_price());
            getTextView(R.id.ltcMinId).setText(stats.getLTC().getMin_24hrs());
            getTextView(R.id.ltcMaxId).setText(stats.getLTC().getMax_24hrs());

            getTextView(R.id.xrpLastId).setText(stats.getXRP().getLast_traded_price());
            getTextView(R.id.xrpMinId).setText(stats.getXRP().getMin_24hrs());
            getTextView(R.id.xrpMaxId).setText(stats.getXRP().getMax_24hrs());

            getTextView(R.id.bchLastId).setText(stats.getBCH().getLast_traded_price());
            getTextView(R.id.bchMinId).setText(stats.getBCH().getMin_24hrs());
            getTextView(R.id.bchMaxId).setText(stats.getBCH().getMax_24hrs());

            Toast.makeText(this, "Chart updated!", Toast.LENGTH_SHORT).show();
        } else {

        }
    }

    private TextView getTextView(int id) {
        return (TextView) findViewById(id);
    }

    private void runAsync() {
        if (SharedPrefs.getInstance().getNotification()) {
            mHandlerTask.run();
        } else {
            if (handler != null) {
                handler.removeCallbacks(mHandlerTask);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        isAppOpen = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        isAppOpen = false;
    }
}
