package minesweeper.example.com;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MineSweeper7_7 extends Activity {
	private ImageButton[] rectButtons = new ImageButton[49];
	private int[] button_flag = {9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
								 9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9};
	private Integer pushcnt = 0;
	private boolean checkflag = true;
	private boolean correctflag = false;
	private boolean modeflag = true;
	
	//メニューの項目
	public static final int MENU_SELECT_A = 0;
	public static final int MENU_SELECT_B = 1;
	public static final int MENU_SELECT_C = 2;
	
	public boolean onCreateOptionsMenu(Menu menu){
	    menu.add(0, MENU_SELECT_A, 0, "オープンモード");
	    menu.add(0, MENU_SELECT_B, 0, "地雷チェックモード");
	    menu.add(0, MENU_SELECT_C, 0, "5 × 5モード");
	    return true;
	}
	
	//メニュー項目の内容
	public boolean onOptionsItemSelected(MenuItem item) {
		    switch (item.getItemId()) {
		    case MENU_SELECT_A:
		    	 Toast.makeText(this, "オープンモード（マスの開くことができます）", Toast.LENGTH_SHORT).show();
		    	 modeflag = true; //オープンモード
		        return true;
		 
		    case MENU_SELECT_B:
		    	Toast.makeText(this, "地雷チェックモード", Toast.LENGTH_SHORT).show();
		    	modeflag = false; //地雷チェックモード
		        return false;
		        
		    case MENU_SELECT_C:
		    	Intent result_act = new Intent(MineSweeper7_7.this, MineSweeper.class);
				startActivity(result_act);
		    }
		    return false;
		}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.minesweeper7_7);
		
		rectButtons[0] = (ImageButton)findViewById(R.id.left_top);
		rectButtons[1] = (ImageButton)findViewById(R.id.seq1_2);
		rectButtons[2] = (ImageButton)findViewById(R.id.seq1_3);
		rectButtons[3] = (ImageButton)findViewById(R.id.left);
		rectButtons[4] = (ImageButton)findViewById(R.id.seq1_5);
		rectButtons[5] = (ImageButton)findViewById(R.id.seq1_6);
		rectButtons[6] = (ImageButton)findViewById(R.id.left_bottom);
		rectButtons[7] = (ImageButton)findViewById(R.id.seq2_1);
		rectButtons[8] = (ImageButton)findViewById(R.id.seq2_2);
		rectButtons[9] = (ImageButton)findViewById(R.id.seq2_3);
		rectButtons[10] = (ImageButton)findViewById(R.id.seq2_4);
		rectButtons[11] = (ImageButton)findViewById(R.id.seq2_5);
		rectButtons[12] = (ImageButton)findViewById(R.id.seq2_6);
		rectButtons[13] = (ImageButton)findViewById(R.id.seq2_7);
		rectButtons[14] = (ImageButton)findViewById(R.id.seq3_1);
		rectButtons[15] = (ImageButton)findViewById(R.id.seq3_2);
		rectButtons[16] = (ImageButton)findViewById(R.id.seq3_3);
		rectButtons[17] = (ImageButton)findViewById(R.id.seq3_4);
		rectButtons[18] = (ImageButton)findViewById(R.id.seq3_5);
		rectButtons[19] = (ImageButton)findViewById(R.id.seq3_6);
		rectButtons[20] = (ImageButton)findViewById(R.id.seq3_7);
		rectButtons[21] = (ImageButton)findViewById(R.id.top);
		rectButtons[22] = (ImageButton)findViewById(R.id.seq4_2);
		rectButtons[23] = (ImageButton)findViewById(R.id.seq4_3);
		rectButtons[24] = (ImageButton)findViewById(R.id.center);
		rectButtons[25] = (ImageButton)findViewById(R.id.seq4_5);
		rectButtons[26] = (ImageButton)findViewById(R.id.seq4_6);
		rectButtons[27] = (ImageButton)findViewById(R.id.bottom);
		rectButtons[28] = (ImageButton)findViewById(R.id.seq5_1);
		rectButtons[29] = (ImageButton)findViewById(R.id.seq5_2);
		rectButtons[30] = (ImageButton)findViewById(R.id.seq5_3);
		rectButtons[31] = (ImageButton)findViewById(R.id.seq5_4);
		rectButtons[32] = (ImageButton)findViewById(R.id.seq5_5);
		rectButtons[33] = (ImageButton)findViewById(R.id.seq5_6);
		rectButtons[34] = (ImageButton)findViewById(R.id.seq5_7);
		rectButtons[35] = (ImageButton)findViewById(R.id.seq6_1);
		rectButtons[36] = (ImageButton)findViewById(R.id.seq6_2);
		rectButtons[37] = (ImageButton)findViewById(R.id.seq6_3);
		rectButtons[38] = (ImageButton)findViewById(R.id.seq6_4);
		rectButtons[39] = (ImageButton)findViewById(R.id.seq6_5);
		rectButtons[40] = (ImageButton)findViewById(R.id.seq6_6);
		rectButtons[41] = (ImageButton)findViewById(R.id.seq6_7);
		rectButtons[42] = (ImageButton)findViewById(R.id.right_top);
		rectButtons[43] = (ImageButton)findViewById(R.id.seq7_2);
		rectButtons[44] = (ImageButton)findViewById(R.id.seq7_3);
		rectButtons[45] = (ImageButton)findViewById(R.id.right);
		rectButtons[46] = (ImageButton)findViewById(R.id.seq7_5);
		rectButtons[47] = (ImageButton)findViewById(R.id.seq7_6);
		rectButtons[48] = (ImageButton)findViewById(R.id.right_bottom);
		
		resetGame();
	}

	public void buttonMethod0_1(View Button){
		
		if(modeflag == true){
			Integer operator = Button.getId();
			correctflag = false;
			checkflag = false;
			
			//押された場所を取得
			Integer pushnum = -1;
			for(int i=0; i<49; i++){
				if(operator.equals(rectButtons[i].getId())){
					pushnum = i;
				}
			}
			
			if (button_flag[1]==0 || button_flag[8]==0 || button_flag[14]==0 || button_flag[15]==0) {
				rectButtons[0].setBackgroundResource(R.drawable.zero);
				rectButtons[1].setBackgroundResource(R.drawable.one);
				rectButtons[7].setBackgroundResource(R.drawable.zero);
				rectButtons[8].setBackgroundResource(R.drawable.two);
				rectButtons[14].setBackgroundResource(R.drawable.one);
				rectButtons[15].setBackgroundResource(R.drawable.two);
				button_flag[0] = 0;
				button_flag[1] = 0;
				button_flag[7] = 0;
				button_flag[8] = 0;
				button_flag[14] = 0;
				button_flag[15] = 0;
				
				//初期化し、再カウント
				pushcnt = 0;
				for(int i=0; i<49; i++){
						pushnum = i;
						if (button_flag[pushnum]==0) {
							pushcnt++;
						}
				}
			} else {
				rectButtons[0].setBackgroundResource(R.drawable.zero);
				rectButtons[1].setBackgroundResource(R.drawable.one);
				rectButtons[7].setBackgroundResource(R.drawable.zero);
				rectButtons[8].setBackgroundResource(R.drawable.two);
				rectButtons[14].setBackgroundResource(R.drawable.one);
				rectButtons[15].setBackgroundResource(R.drawable.two);
				button_flag[0] = 0;
				button_flag[1] = 0;
				button_flag[7] = 0;
				button_flag[8] = 0;
				button_flag[14] = 0;
				button_flag[15] = 0;
				pushcnt = pushcnt + 6;
			}
		
		hitlist();		
		
		}else if (modeflag == false) {
			
			Integer operator = Button.getId();
			correctflag = false;
			checkflag = true;
			
			//押された場所を取得
			Integer pushnum = -1;
			for(int i=0; i<49; i++){
				if(operator.equals(rectButtons[i].getId())){
					pushnum = i;
				}
			}
		
			if (button_flag[pushnum] != 0) {
				rectButtons[pushnum].setBackgroundResource(R.drawable.flg);
			}
				
		}	
	}
	
	public void buttonMethod0_2(View Button){
		
		if(modeflag == true){
			Integer operator = Button.getId();
			correctflag = false;
			checkflag = false;
			
			//押された場所を取得
			Integer pushnum = -1;
			for(int i=0; i<49; i++){
				if(operator.equals(rectButtons[i].getId())){
					pushnum = i;
				}
			}
			
			if (button_flag[5]==0 || button_flag[12]==0 || button_flag[19]==0 || button_flag[20]==0) {
				rectButtons[5].setBackgroundResource(R.drawable.one);
				rectButtons[6].setBackgroundResource(R.drawable.zero);
				rectButtons[12].setBackgroundResource(R.drawable.one);
				rectButtons[13].setBackgroundResource(R.drawable.zero);
				rectButtons[19].setBackgroundResource(R.drawable.two);
				rectButtons[20].setBackgroundResource(R.drawable.one);
				button_flag[5] = 0;
				button_flag[6] = 0;
				button_flag[12] = 0;
				button_flag[13] = 0;
				button_flag[19] = 0;
				button_flag[20] = 0;
				
				//初期化し、再カウント
				pushcnt = 0;
				for(int i=0; i<49; i++){
						pushnum = i;
						if (button_flag[pushnum]==0) {
							pushcnt++;
						}
				}
			} else {
				rectButtons[5].setBackgroundResource(R.drawable.one);
				rectButtons[6].setBackgroundResource(R.drawable.zero);
				rectButtons[12].setBackgroundResource(R.drawable.one);
				rectButtons[13].setBackgroundResource(R.drawable.zero);
				rectButtons[19].setBackgroundResource(R.drawable.two);
				rectButtons[20].setBackgroundResource(R.drawable.one);
				button_flag[5] = 0;
				button_flag[6] = 0;
				button_flag[12] = 0;
				button_flag[13] = 0;
				button_flag[19] = 0;
				button_flag[20] = 0;
				pushcnt = pushcnt + 6;
			}
		
		hitlist();		
		
		}else if (modeflag == false) {
			
			Integer operator = Button.getId();
			correctflag = false;
			checkflag = true;
			
			//押された場所を取得
			Integer pushnum = -1;
			for(int i=0; i<49; i++){
				if(operator.equals(rectButtons[i].getId())){
					pushnum = i;
				}
			}
		
			if (button_flag[pushnum] != 0) {
				rectButtons[pushnum].setBackgroundResource(R.drawable.flg);
			}
				
		}	
	}
	
	public void buttonMethod0_3(View Button){
		
		if(modeflag == true){
			Integer operator = Button.getId();
			correctflag = false;
			checkflag = false;
			
			//押された場所を取得
			Integer pushnum = -1;
			for(int i=0; i<49; i++){
				if(operator.equals(rectButtons[i].getId())){
					pushnum = i;
				}
			}
			
			if (button_flag[33]==0 || button_flag[34]==0 || button_flag[40]==0 || button_flag[47]==0) {
				rectButtons[33].setBackgroundResource(R.drawable.three);
				rectButtons[34].setBackgroundResource(R.drawable.one);
				rectButtons[40].setBackgroundResource(R.drawable.two);
				rectButtons[41].setBackgroundResource(R.drawable.zero);
				rectButtons[47].setBackgroundResource(R.drawable.one);
				rectButtons[48].setBackgroundResource(R.drawable.zero);
				button_flag[33] = 0;
				button_flag[34] = 0;
				button_flag[40] = 0;
				button_flag[41] = 0;
				button_flag[47] = 0;
				button_flag[48] = 0;
				
				//初期化し、再カウント
				pushcnt = 0;
				for(int i=0; i<49; i++){
						pushnum = i;
						if (button_flag[pushnum]==0) {
							pushcnt++;
						}
				}
			} else {
				rectButtons[33].setBackgroundResource(R.drawable.three);
				rectButtons[34].setBackgroundResource(R.drawable.one);
				rectButtons[40].setBackgroundResource(R.drawable.two);
				rectButtons[41].setBackgroundResource(R.drawable.zero);
				rectButtons[47].setBackgroundResource(R.drawable.one);
				rectButtons[48].setBackgroundResource(R.drawable.zero);
				button_flag[33] = 0;
				button_flag[34] = 0;
				button_flag[40] = 0;
				button_flag[41] = 0;
				button_flag[47] = 0;
				button_flag[48] = 0;
				pushcnt = pushcnt + 6;
			}
		
		hitlist();		
		
		}else if (modeflag == false) {
			
			Integer operator = Button.getId();
			correctflag = false;
			checkflag = true;
			
			//押された場所を取得
			Integer pushnum = -1;
			for(int i=0; i<49; i++){
				if(operator.equals(rectButtons[i].getId())){
					pushnum = i;
				}
			}
		
			if (button_flag[pushnum] != 0) {
				rectButtons[pushnum].setBackgroundResource(R.drawable.flg);
			}
				
		}	
	}
	
	public void buttonMethod1(View Button){
		
		if(modeflag == true){
			Integer operator = Button.getId();
			correctflag = false;
			
			//押された場所を取得
			Integer pushnum = -1;
			for(int i=0; i<49; i++){
				if(operator.equals(rectButtons[i].getId())){
					pushnum = i;
				}
			}
		
				rectButtons[pushnum].setBackgroundResource(R.drawable.one);
				checkflag = false ;
				button_flag[pushnum] = 0;
				pushcnt++;

		hitlist();
		
		}else if (modeflag == false) {
			
			Integer operator = Button.getId();
			correctflag = false;
			
			//押された場所を取得
			Integer pushnum = -1;
			for(int i=0; i<49; i++){
				if(operator.equals(rectButtons[i].getId())){
					pushnum = i;
				}
			}
		
			if (button_flag[pushnum] != 0) {
				rectButtons[pushnum].setBackgroundResource(R.drawable.flg);
			}
		}
	}
	
	public void buttonMethod2(View Button){
		
		if(modeflag == true){
			Integer operator = Button.getId();
			correctflag = false;
			
			//押された場所を取得
			Integer pushnum = -1;
			for(int i=0; i<49; i++){
				if(operator.equals(rectButtons[i].getId())){
					pushnum = i;
				}
			}
		
				rectButtons[pushnum].setBackgroundResource(R.drawable.two);
				checkflag = false ;
				button_flag[pushnum] = 0;
				pushcnt++;

		hitlist();
		
		}else if (modeflag == false) {
			
			Integer operator = Button.getId();
			correctflag = false;
			
			//押された場所を取得
			Integer pushnum = -1;
			for(int i=0; i<49; i++){
				if(operator.equals(rectButtons[i].getId())){
					pushnum = i;
				}
			}
		
			if (button_flag[pushnum] != 0) {
				rectButtons[pushnum].setBackgroundResource(R.drawable.flg);
			}
		}
	}
	
	public void buttonMethod3(View Button){
		
		if(modeflag == true){
			Integer operator = Button.getId();
			correctflag = false;
			
			//押された場所を取得
			Integer pushnum = -1;
			for(int i=0; i<49; i++){
				if(operator.equals(rectButtons[i].getId())){
					pushnum = i;
				}
			}
		
				rectButtons[pushnum].setBackgroundResource(R.drawable.three);
				checkflag = false ;
				button_flag[pushnum] = 0;
				pushcnt++;

		hitlist();
		
		}else if (modeflag == false) {
			Integer operator = Button.getId();
			correctflag = false;
			
			//押された場所を取得
			Integer pushnum = -1;
			for(int i=0; i<49; i++){
				if(operator.equals(rectButtons[i].getId())){
					pushnum = i;
				}
			}
		
			if (button_flag[pushnum] != 0) {
				rectButtons[pushnum].setBackgroundResource(R.drawable.flg);
			}
		}
	}
	
	public void buttonMethodBatu(View Button){
		
		if (modeflag == true) {
			Integer operator = Button.getId();
			correctflag = false;
			
			//押された場所を取得
			Integer pushnum = -1;
			for(int i=0; i<49; i++){
				if(operator.equals(rectButtons[i].getId())){
					pushnum = i;
				}
			}
			
			if(button_flag[2]==9 || button_flag[11]==9 || button_flag[16]==9 || button_flag[21]==9 || button_flag[24]==9 ||
		       button_flag[26]==9 || button_flag[32]==9 || button_flag[39]==9 || button_flag[43]==9){
				rectButtons[pushnum].setBackgroundResource(R.drawable.batu);
				checkflag = false ;
				button_flag[pushnum] = 0;
		}
			
			hitlist();
			
		}else if (modeflag == false) {
			Integer operator = Button.getId();
			correctflag = false;
			
			//押された場所を取得
			Integer pushnum = -1;
			for(int i=0; i<49; i++){
				if(operator.equals(rectButtons[i].getId())){
					pushnum = i;
				}
			}
		
				rectButtons[pushnum].setBackgroundResource(R.drawable.flg);
		}
	}
	
	//ゲームリセットの処理
	private void resetGame(){
		for(int i=0;i<49;i++){
				rectButtons[i].setBackgroundResource(R.drawable.hatena);
				button_flag[i] = 9;
				pushcnt = 0;
				checkflag = true;
			}
		}
	
	//判定処理
	public void hitlist(){
		//ゲームオーバー処理
		if(button_flag[2]==0 || button_flag[11]==0 || button_flag[16]==0 || button_flag[21]==0 || button_flag[24] == 0 ||
		   button_flag[26]==0 || button_flag[32]==0 || button_flag[39]==0 || button_flag[43]==0){
			Toast.makeText(this, "ゲームオーバー", Toast.LENGTH_SHORT).show();
			correctflag = true;
			alert();
		}
		
		//ゲームクリア処理
		if(pushcnt>=40){
			pushcnt = 0;
			Toast.makeText(this, "ゲームクリア！", Toast.LENGTH_LONG).show();
			alert();
		}		
	}
	
	//アラートダイアログの処理
	public void alert(){
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
	    alertDialogBuilder.setPositiveButton("リトライ",
	         new DialogInterface.OnClickListener() {
	             @Override
	             public void onClick(DialogInterface dialog, int which) {
	             resetGame();
	             }
	         });
	        
	        alertDialogBuilder.setCancelable(true);
	        AlertDialog alertDialog = alertDialogBuilder.create();
	        alertDialog.show();
		}

}
