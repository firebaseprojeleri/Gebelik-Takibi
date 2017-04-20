package com.gebeliktakibi;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

public class AnaEkran extends AppCompatActivity implements ActionBar.TabListener {

    // action bar
    private android.support.v7.app.ActionBar actionBar;
    private Menu optionsMenu;
    private ViewPager viewPager;
    private TabsPager adapter;
    // Tab başlıkları
    private String[] tabs = {"Birinci", "İkinci", "Üçüncü"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_ekran);

        //ACTİON BAR İŞLEMLERİ
        actionBar = getSupportActionBar();

        // Action Bar Başlığı saklar
        actionBar.setDisplayShowTitleEnabled(false);


        //TAB ve SWIPE İŞLEMLERİ

        viewPager = (ViewPager) findViewById(R.id.pager); //xml de tanımladığımız pager alıyoruz
        adapter = new TabsPager(getSupportFragmentManager());//TabsPager objesi oluşturuyoruz

        viewPager.setAdapter(adapter); //pager ımızı oluşturduğumuz objeye bağlıyoruz.
        actionBar.setNavigationMode(android.support.v7.app.ActionBar.NAVIGATION_MODE_TABS);//ActionBarı tablı kullanmak için


        for (int i = 0; i < tabs.length; i++) { //Tabları ekliyorum
            actionBar.addTab(actionBar.newTab().setText(tabs[i]).setTabListener(this)); //Action Barlara tabları ekledik
        }


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { //tablar arasındaki geçişleri dinleyen listener

            @Override
            public void onPageSelected(int position) {
                // sayfa değiştiğinde çalışır
                actionBar.setSelectedNavigationItem(position);

                //actionBar.setSelectedNavigationItem(2);//son tab ı seçili hale getirir.
                //1. tab 0 index i ile seçilir
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
       // Toast.makeText(getApplicationContext(), "" + tab.getPosition() + ".Tab seçildi", Toast.LENGTH_LONG).show();
        viewPager.setCurrentItem(tab.getPosition(),true);

        //tab.getPosition()  //Hangi tabın seçildiğini anlamak için mesala 1. tab seçildiyse 0 değeri döner 2. tabda 1 ,3.tabda 2 değeri döner
        //tab.setText("deneme"); //seçilen tabın string değerini-adını değiştirmeye yarar
        //tab.setIcon(R.drawable.xx)  tab da icon kullanmak için
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
