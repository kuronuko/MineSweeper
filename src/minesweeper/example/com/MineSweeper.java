package minesweeper.example.com;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MineSweeper extends Activity {
	private ImageButton[] rectButtons = new ImageButton[25];
	private int[] button_flag = {9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9};
	private Integer pushcnt = 0;
	private boolean checkflag = true;
	private boolean correctflag = false;
	private boolean modeflag = true;
	
	//���j���[�̍���
	public static final int MENU_SELECT_A = 0;
	public static final int MENU_SELECT_B = 1;
	
	public boolean onCreateOptionsMenu(Menu menu){
	    menu.add(0, MENU_SELECT_A, 0, "�I�[�v�����[�h");
	    menu.add(0, MENU_SELECT_B, 0, "�n���`�F�b�N���[�h");
	    return true;
	}
	
	//���j���[���ڂ̓��e
	public boolean onOptionsItemSelected(MenuItem item) {
		    switch (item.getItemId()) {
		    case MENU_SELECT_A:
		    	 Toast.makeText(this, "�I�[�v�����[�h�i�}�X�̊J�����Ƃ��ł��܂��j", Toast.LENGTH_SHORT).show();
		    	 modeflag = true; //�I�[�v�����[�h
		        return true;
		 
		    case MENU_SELECT_B:
		    	Toast.makeText(this, "�n���`�F�b�N���[�h", Toast.LENGTH_SHORT).show();
		    	modeflag = false; //�n���`�F�b�N���[�h
		        return false;
		    }
		    return false;
		}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		rectButtons[0] = (ImageButton)findViewById(R.id.left_top);
		rectButtons[1] = (ImageButton)findViewById(R.id.seq1_2);
		rectButtons[2] = (ImageButton)findViewById(R.id.left);
		rectButtons[3] = (ImageButton)findViewById(R.id.seq1_4);
		rectButtons[4] = (ImageButton)findViewById(R.id.left_bottom);
		rectButtons[5] = (ImageButton)findViewById(R.id.seq2_1);
		rectButtons[6] = (ImageButton)findViewById(R.id.seq2_2);
		rectButtons[7] = (ImageButton)findViewById(R.id.seq2_3);
		rectButtons[8] = (ImageButton)findViewById(R.id.seq2_4);
		rectButtons[9] = (ImageButton)findViewById(R.id.seq2_5);
		rectButtons[10] = (ImageButton)findViewById(R.id.top);
		rectButtons[11] = (ImageButton)findViewById(R.id.seq3_2);
		rectButtons[12] = (ImageButton)findViewById(R.id.center);
		rectButtons[13] = (ImageButton)findViewById(R.id.seq3_4);
		rectButtons[14] = (ImageButton)findViewById(R.id.bottom);
		rectButtons[15] = (ImageButton)findViewById(R.id.seq4_1);
		rectButtons[16] = (ImageButton)findViewById(R.id.seq4_2);
		rectButtons[17] = (ImageButton)findViewById(R.id.seq4_3);
		rectButtons[18] = (ImageButton)findViewById(R.id.seq4_4);
		rectButtons[19] = (ImageButton)findViewById(R.id.seq4_5);
		rectButtons[20] = (ImageButton)findViewById(R.id.right_top);
		rectButtons[21] = (ImageButton)findViewById(R.id.seq5_2);
		rectButtons[22] = (ImageButton)findViewById(R.id.right);
		rectButtons[23] = (ImageButton)findViewById(R.id.seq5_4);
		rectButtons[24] = (ImageButton)findViewById(R.id.right_bottom);
		
		resetGame();
	}

public void buttonMethod0(View Button){
		
		if(modeflag == true){
			Integer operator = Button.getId();
			correctflag = false;
			checkflag = false;
			
			//�����ꂽ�ꏊ���擾
			Integer pushnum = -1;
			for(int i=0; i<25; i++){
				if(operator.equals(rectButtons[i].getId())){
					pushnum = i;
				}
			}
		
				rectButtons[pushnum].setBackgroundResource(R.drawable.zero);
				button_flag[pushnum] = 0;
				pushcnt++;
		
		hitlist();		
		
		}else if (modeflag == false) {
			
			Integer operator = Button.getId();
			correctflag = false;
			checkflag = true;
			
			//�����ꂽ�ꏊ���擾
			Integer pushnum = -1;
			for(int i=0; i<25; i++){
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
			
			//�����ꂽ�ꏊ���擾
			Integer pushnum = -1;
			for(int i=0; i<25; i++){
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
			
			//�����ꂽ�ꏊ���擾
			Integer pushnum = -1;
			for(int i=0; i<25; i++){
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
			
			//�����ꂽ�ꏊ���擾
			Integer pushnum = -1;
			for(int i=0; i<25; i++){
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
			
			//�����ꂽ�ꏊ���擾
			Integer pushnum = -1;
			for(int i=0; i<25; i++){
				if(operator.equals(rectButtons[i].getId())){
					pushnum = i;
				}
			}
		
			if (button_flag[pushnum] != 0) {
				rectButtons[pushnum].setBackgroundResource(R.drawable.flg);
//				senkou = false ;
			}
		}
	}
	
	public void buttonMethod3(View Button){
		
		if(modeflag == true){
			Integer operator = Button.getId();
			correctflag = false;
			
			//�����ꂽ�ꏊ���擾
			Integer pushnum = -1;
			for(int i=0; i<25; i++){
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
			
			//�����ꂽ�ꏊ���擾
			Integer pushnum = -1;
			for(int i=0; i<25; i++){
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
			
			//�����ꂽ�ꏊ���擾
			Integer pushnum = -1;
			for(int i=0; i<25; i++){
				if(operator.equals(rectButtons[i].getId())){
					pushnum = i;
				}
			}
			
			if(button_flag[5] == 9 || button_flag[10] == 9 || button_flag[12] == 9 || button_flag[18] == 9 || button_flag[21] == 9){
				rectButtons[pushnum].setBackgroundResource(R.drawable.batu);
				checkflag = false ;
				button_flag[pushnum] = 0;
				pushcnt++;
		}
			
			hitlist();
			
		}else if (modeflag == false) {
			Integer operator = Button.getId();
			correctflag = false;
			
			//�����ꂽ�ꏊ���擾
			Integer pushnum = -1;
			for(int i=0; i<25; i++){
				if(operator.equals(rectButtons[i].getId())){
					pushnum = i;
				}
			}
		
				rectButtons[pushnum].setBackgroundResource(R.drawable.flg);
//				checkflag = false ;
		}
	}
	
	//�Q�[�����Z�b�g�̏���
	private void resetGame(){
		for(int i=0;i<25;i++){
				rectButtons[i].setBackgroundResource(R.drawable.hatena);
				button_flag[i] = 9;
				pushcnt = 0;
				checkflag = true;
			}
		}
	
	//���菈��
	public void hitlist(){
		//�Q�[���I�[�o�[����
		if(button_flag[5]==0 || button_flag[10]==0 || button_flag[12]==0 || button_flag[18]==0 || button_flag[21]==0){
			Toast.makeText(this, "�Q�[���I�[�o�[", Toast.LENGTH_SHORT).show();
			correctflag = true;
			alert();
		}
		
		//�Q�[���N���A����
		if(pushcnt>=20){
			pushcnt = 0;
			Toast.makeText(this, "�Q�[���N���A�I", Toast.LENGTH_SHORT).show();
			alert();
		}		
	}
	
	//�A���[�g�_�C�A���O�̏���
	public void alert(){
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
	    alertDialogBuilder.setPositiveButton("���g���C",
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
