/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;

/**
 * @author Taha
 */
public class Draw2D extends MIDlet implements CommandListener {



    private boolean midletPaused = false;
    private RecordStore rs;
    private static final String STORE_NAME = "Rooms";
    public String roomNo;
    public String insName;
    public String telNo;
    public List list;

    ////////////////////
     Alert timeAlert;


  public Draw2D() {
      super();

    timeAlert = new Alert("Alert!");
    timeAlert.setString(new Date().toString());



  }


  public void publishList(){
      PacerCanvas pac = new PacerCanvas(1.0);

      list = new List("Select the Empty Room",Choice.IMPLICIT);
      try {
          System.out.println("The Arr first G " + pac.getSplit().length);
          String [][] paintArr = new String [rs.getNumRecords()][3] ;
            paintArr = pac.getSplit();


     for (int i =0 ; i <paintArr.length;i++){
         if (paintArr[i][1].equals("empty"))
            list.append(paintArr[i][0], null);
     }
     //allEmpty = new Form("allEmpty", new Item[] { getChoiceGroup() });
                 
                } catch (Exception e) {
          System.out.println("Inside Catch " + e.getMessage());
      }
 

  }



    private void createRecord() throws RecordStoreException{
        rs = RecordStore.openRecordStore(STORE_NAME,true);

    }//createRecored
    
    public void storeRecord(String word) throws RecordStoreException{
        int newRecordId = 0;
        byte[] rec = word.getBytes();
        if (word.length() ==0){
            rec = new String ("None").getBytes();
        }
        try{
            newRecordId = rs.addRecord(rec, 0, rec.length);
        }catch (Exception e){}
        System.out.println("Record Store now has "+ rs.getNumRecords()+ " Records using " + rs.getSize() +" Bytes"
                + "{" + rs.getSizeAvailable()+ " Bytes Free"+"}");
    }//storeRecord

    public String getRecord(int roomNo) throws Exception{
        System.out.println("Inside getRecord "+roomNo);
        String value="";
        String Bvalue="";
        int recordSize = 0;
        int index;
        String [] tempValue;
        System.out.println("No Rec="+ rs.getNumRecords());
        for (index=1;index <= rs.getNumRecords();index++){
            System.out.println("index="+index);

           if (index < rs.getSize()){
                recordSize = rs.getRecordSize(index);
                System.out.println("size="+ rs.getSize());
            }

            if (recordSize >0){
                Bvalue = new String(rs.getRecord(index));
                System.out.println("1 Record Retrieved: "+index + " value: " + value);
                tempValue = splitRecord(Bvalue, 0, Bvalue.length());
                if (roomNo == Integer.parseInt(tempValue[0])){
                   System.out.println("Record Retrieved: "+index + " value: " + value);
                   //tempValue = splitRecord(value, 0, value.length());
                   value = tempValue[0];
                   insName = tempValue[1];
                   telNo = tempValue[2];
                }
                
            }
        }
        System.out.println("insName:"+insName);
        System.out.println("value:"+value);
        System.out.println("tel:"+telNo);
        return value;


    }//getRecord

   public String [] splitRecord(String s,int n,int m)
   {
        String temp [] = new String[3];
		String a="",b="",c="";
   		int count1=0,count2=0,count3=0;
   		if(s.equals("")) return null;
	   	for(int i=0;i<s.length();i++)
	   	{
            count2++;
            if (s.substring(i, i+1).equals(":")){
                count1++;
            }
            else{
                if (count1 <1){
                    a+= s.substring(i, i+1);
                }
                else if(count1 == 1){
                    b+= s.substring(i, i+1);
                }
                else{
                    c+= s.substring(i, i+1);
                }
            }

         }//for
           System.out.println("a::"+a+" b::"+b+" c::"+c);
           temp[0]= a;
           temp[1]= b;
           temp[2]= c;
	   	return temp;
  }//split



   //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
   private Form mainForm;
   private ChoiceGroup choiceGroup;
   private Form addInstructor;
   private TextField txtName;
   private TextField txtTel;
   private TextField txtNo;
   private StringItem stringItem;
   private Form FindRoom;
   private TextField txtFind;
   private StringItem showFound;
   private Form drawRoom;
   private TextField txtMap;
   private Form allLevel;
   private TextField txtLevel;
   private Form allEmpty;
   private Command exitCommand;
   private Command okCommand;
   private Command okCommand1;
   private Command saveInstructor;
   private Command exitFindRoom;
   private Command getRoom;
   private Command newRecord;
   private Command exitCommand1;
   private Command backCommand;
   private Command okCommand3;
   private Command okCommandLevel;
   private Command okCommandEmpty;
   private Command backCommand1;
   //</editor-fold>//GEN-END:|fields|0|

    /**
     * The Draw2D constructor.
     */
   

   //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
   //</editor-fold>//GEN-END:|methods|0|

   //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
   /**
    * Initilizes the application.
    * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
    */
   private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
   }//GEN-BEGIN:|0-initialize|2|
   //</editor-fold>//GEN-END:|0-initialize|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
   /**
    * Performs an action assigned to the Mobile Device - MIDlet Started point.
    */
   public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
       switchDisplayable(null, getMainForm());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
   }//GEN-BEGIN:|3-startMIDlet|2|
   //</editor-fold>//GEN-END:|3-startMIDlet|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
   /**
    * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
    */
   public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
   }//GEN-BEGIN:|4-resumeMIDlet|2|
   //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
   /**
    * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
    * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
    * @param nextDisplayable the Displayable to be set
    */
   public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
       Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
       if (alert == null) {
           display.setCurrent(nextDisplayable);
       } else {
           display.setCurrent(alert, nextDisplayable);
       }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
   }//GEN-BEGIN:|5-switchDisplayable|2|
   //</editor-fold>//GEN-END:|5-switchDisplayable|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
   /**
    * Called by a system to indicated that a command has been invoked on a particular displayable.
    * @param command the Command that was invoked
    * @param displayable the Displayable where the command was invoked
    */
   public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
       if (displayable == FindRoom) {//GEN-BEGIN:|7-commandAction|1|43-preAction
           if (command == exitFindRoom) {//GEN-END:|7-commandAction|1|43-preAction
                // write pre-action user code here
               switchDisplayable(null, getMainForm());//GEN-LINE:|7-commandAction|2|43-postAction
                // write post-action user code here
                txtName.setString("");
                txtNo.setString("");
                txtTel.setString("");
                stringItem.setText("");
           } else if (command == getRoom) {//GEN-LINE:|7-commandAction|3|46-preAction
                String drString="TTTT";
                if (txtFind.getString().length() == 3)
                {
                    try {
                            System.out.println("before");
                            drString = getRecord(Integer.parseInt(txtFind.getString().toString()));
                            roomNo = drString;
                        } catch (Exception e) {
                        }
                        if (drString.length() != 3){
                            showFound.setText("Room Number Not Found");
                        }
                        else {
                            System.out.println("drString " +drString);
                           // showFound.setText(drString);

                            //txtDraw.setText("Room : ");

                            showFound.setText("");
                            switchDisplayable(null, getDrawRoom());//GEN-LINE:|7-commandAction|4|46-postAction

                            Displayable d = new PacerCanvas(drString);
                             d.addCommand(new Command("Back", Command.BACK, 0));
                             d.setCommandListener(new CommandListener() {
                             public void commandAction(Command c, Displayable s) {
                                //notifyDestroyed();
                                 switchDisplayable(null, getFindRoom());
                              }
                             });
                             Display.getDisplay(this).setCurrent(d);
                            //txtMap.setString(drString);
                             txtFind.setString("");
                        }


                }//if
                else{
                    showFound.setText("Room Number Must Be 3 Digits");
                    txtFind.setString("");
                    drString = "";
                }//else
           }//GEN-BEGIN:|7-commandAction|5|31-preAction
       } else if (displayable == addInstructor) {
           if (command == exitCommand) {//GEN-END:|7-commandAction|5|31-preAction
                // write pre-action user code here
               switchDisplayable(null, getMainForm());//GEN-LINE:|7-commandAction|6|31-postAction
                // write post-action user code here
           } else if (command == newRecord) {//GEN-LINE:|7-commandAction|7|50-preAction
                // write pre-action user code here
                txtName.setString("");
                txtNo.setString("");
                txtTel.setString("");
                stringItem.setText("");

//GEN-LINE:|7-commandAction|8|50-postAction
                // write post-action user code here
           } else if (command == saveInstructor) {//GEN-LINE:|7-commandAction|9|34-preAction
                // write pre-action user code here
                if (txtName.getString().equals("") || txtNo.getString().equals("") || txtTel.getString().equals(""))
                    stringItem.setText("All Field Must be Filled");
                else{
                    try {
                        if(getRecord(Integer.parseInt(txtNo.getString())).equals(txtNo.getString())){
                            stringItem.setText("Room Number Already Exist ");

                            txtNo.setString("");

                        }
                        else
                        {
                                storeRecord(txtNo.getString()+":"+txtName.getString()+":" + txtTel.getString());
                                System.out.println(""+txtNo.getString()+"::"+txtName.getString()+"::" + txtTel.getString());
                                stringItem.setText("Record Stored successfully");



                        }
                    } catch (Exception e) {
                    }
                }
               //;
//GEN-LINE:|7-commandAction|10|34-postAction
                // write post-action user code here
           }//GEN-BEGIN:|7-commandAction|11|76-preAction
       } else if (displayable == allEmpty) {
           if (command == backCommand1) {//GEN-END:|7-commandAction|11|76-preAction
                // write pre-action user code here
               switchDisplayable(null, getMainForm());//GEN-LINE:|7-commandAction|12|76-postAction
                // write post-action user code here
           } else if (command == okCommandEmpty) {//GEN-LINE:|7-commandAction|13|74-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|14|74-postAction
                // write post-action user code here


                Displayable d = new PacerCanvas(1.0);
                switchDisplayable(null, getDrawRoom());
                d.addCommand(new Command("Back", Command.BACK, 0));
                d.setCommandListener(new CommandListener() {
                public void commandAction(Command c, Displayable s) {
                    //notifyDestroyed();
                     switchDisplayable(null, getAllEmpty());
                  }
                 });
                 Display.getDisplay(this).setCurrent(d);
                 //* */
           }//GEN-BEGIN:|7-commandAction|15|64-preAction
       } else if (displayable == allLevel) {
           if (command == backCommand) {//GEN-END:|7-commandAction|15|64-preAction
                // write pre-action user code here
               switchDisplayable(null, getMainForm());//GEN-LINE:|7-commandAction|16|64-postAction
                // write post-action user code here
           } else if (command == okCommandLevel) {//GEN-LINE:|7-commandAction|17|67-preAction
                // write pre-action user code here
                Displayable d = new PacerCanvas(Integer.parseInt(txtLevel.getString()));
                switchDisplayable(null, getDrawRoom());
                d.addCommand(new Command("Back", Command.BACK, 0));
                d.setCommandListener(new CommandListener() {
                public void commandAction(Command c, Displayable s) {
                    //notifyDestroyed();
                     switchDisplayable(null, getAllLevel());
                  }
                 });
                 Display.getDisplay(this).setCurrent(d);
//GEN-LINE:|7-commandAction|18|67-postAction
                // write post-action user code here
           }//GEN-BEGIN:|7-commandAction|19|54-preAction
       } else if (displayable == drawRoom) {
           if (command == exitCommand1) {//GEN-END:|7-commandAction|19|54-preAction
                // write pre-action user code here
               switchDisplayable(null, getFindRoom());//GEN-LINE:|7-commandAction|20|54-postAction
                // write post-action user code here
           }//GEN-BEGIN:|7-commandAction|21|16-preAction
       } else if (displayable == mainForm) {
           if (command == exitCommand) {//GEN-END:|7-commandAction|21|16-preAction
                // write pre-action user code here
               exitMIDlet();//GEN-LINE:|7-commandAction|22|16-postAction
                // write post-action user code here
           } else if (command == okCommand) {//GEN-LINE:|7-commandAction|23|19-preAction
                // write pre-action user code here

                if ( choiceGroup.getSelectedIndex() == 0){
                    System.out.println("choice " + choiceGroup.getSelectedIndex());
                    switchDisplayable(null, getAddInstructor());//GEN-LINE:|7-commandAction|24|19-postAction
                // write post-action user code here
                txtName.setString("");
                txtNo.setString("");
                txtTel.setString("");
                stringItem.setText("");
                }//if
                if ( choiceGroup.getSelectedIndex() == 1){
                     switchDisplayable(null, getFindRoom());
                }

                if ( choiceGroup.getSelectedIndex() == 2){
                     switchDisplayable(null, getAllLevel());
                }
                if ( choiceGroup.getSelectedIndex() == 3){
                     switchDisplayable(null, getAllEmpty());

                }
           }//GEN-BEGIN:|7-commandAction|25|7-postCommandAction
       }//GEN-END:|7-commandAction|25|7-postCommandAction
        // write post-action user code here
   }//GEN-BEGIN:|7-commandAction|26|
   //</editor-fold>//GEN-END:|7-commandAction|26|

   //<editor-fold defaultstate="collapsed" desc=" Generated Getter: mainForm ">//GEN-BEGIN:|14-getter|0|14-preInit
   /**
    * Returns an initiliazed instance of mainForm component.
    * @return the initialized component instance
    */
   public Form getMainForm() {
       if (mainForm == null) {//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
           mainForm = new Form("Main", new Item[] { getChoiceGroup() });//GEN-BEGIN:|14-getter|1|14-postInit
           mainForm.addCommand(getExitCommand());
           mainForm.addCommand(getOkCommand());
           mainForm.setCommandListener(this);//GEN-END:|14-getter|1|14-postInit
            // write post-init user code here
            System.out.println("Taha");
       }//GEN-BEGIN:|14-getter|2|
       return mainForm;
   }
   //</editor-fold>//GEN-END:|14-getter|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|15-getter|0|15-preInit
   /**
    * Returns an initiliazed instance of exitCommand component.
    * @return the initialized component instance
    */
   public Command getExitCommand() {
       if (exitCommand == null) {//GEN-END:|15-getter|0|15-preInit
            // write pre-init user code here
           exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|15-getter|1|15-postInit
            // write post-init user code here
       }//GEN-BEGIN:|15-getter|2|
       return exitCommand;
   }
   //</editor-fold>//GEN-END:|15-getter|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
   /**
    * Returns an initiliazed instance of okCommand component.
    * @return the initialized component instance
    */
   public Command getOkCommand() {
       if (okCommand == null) {//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
           okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
       }//GEN-BEGIN:|18-getter|2|
       return okCommand;
   }
   //</editor-fold>//GEN-END:|18-getter|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Getter: choiceGroup ">//GEN-BEGIN:|25-getter|0|25-preInit
   /**
    * Returns an initiliazed instance of choiceGroup component.
    * @return the initialized component instance
    */
   public ChoiceGroup getChoiceGroup() {
       if (choiceGroup == null) {//GEN-END:|25-getter|0|25-preInit
            // write pre-init user code here
           choiceGroup = new ChoiceGroup("What to Do", Choice.EXCLUSIVE);//GEN-BEGIN:|25-getter|1|25-postInit
           choiceGroup.append("New Room", null);
           choiceGroup.append("Find Room", null);
           choiceGroup.append("Level Rooms", null);
           choiceGroup.append("Empty Rooms", null);
           choiceGroup.append("Web Service", null);
           choiceGroup.setSelectedFlags(new boolean[] { false, false, false, false, false });
           choiceGroup.setFont(0, null);
           choiceGroup.setFont(1, null);
           choiceGroup.setFont(2, null);
           choiceGroup.setFont(3, null);
           choiceGroup.setFont(4, null);//GEN-END:|25-getter|1|25-postInit
            // write post-init user code here
       }//GEN-BEGIN:|25-getter|2|
       return choiceGroup;
   }
   //</editor-fold>//GEN-END:|25-getter|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Getter: addInstructor ">//GEN-BEGIN:|30-getter|0|30-preInit
   /**
    * Returns an initiliazed instance of addInstructor component.
    * @return the initialized component instance
    */
   public Form getAddInstructor() {
       if (addInstructor == null) {//GEN-END:|30-getter|0|30-preInit
            // write pre-init user code here
           addInstructor = new Form("Add Instructor", new Item[] { getTxtName(), getTxtTel(), getTxtNo(), getStringItem() });//GEN-BEGIN:|30-getter|1|30-postInit
           addInstructor.addCommand(getExitCommand());
           addInstructor.addCommand(getSaveInstructor());
           addInstructor.addCommand(getNewRecord());
           addInstructor.setCommandListener(this);//GEN-END:|30-getter|1|30-postInit
            // write post-init user code here
       }//GEN-BEGIN:|30-getter|2|
       return addInstructor;
   }
   //</editor-fold>//GEN-END:|30-getter|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Getter: txtName ">//GEN-BEGIN:|35-getter|0|35-preInit
   /**
    * Returns an initiliazed instance of txtName component.
    * @return the initialized component instance
    */
   public TextField getTxtName() {
       if (txtName == null) {//GEN-END:|35-getter|0|35-preInit
            // write pre-init user code here
           txtName = new TextField("Instructor Name", null, 32, TextField.ANY);//GEN-LINE:|35-getter|1|35-postInit
            // write post-init user code here
       }//GEN-BEGIN:|35-getter|2|
       return txtName;
   }
   //</editor-fold>//GEN-END:|35-getter|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Getter: txtTel ">//GEN-BEGIN:|36-getter|0|36-preInit
   /**
    * Returns an initiliazed instance of txtTel component.
    * @return the initialized component instance
    */
   public TextField getTxtTel() {
       if (txtTel == null) {//GEN-END:|36-getter|0|36-preInit
            // write pre-init user code here
           txtTel = new TextField("Tel.", null, 32, TextField.ANY);//GEN-LINE:|36-getter|1|36-postInit
            // write post-init user code here
       }//GEN-BEGIN:|36-getter|2|
       return txtTel;
   }
   //</editor-fold>//GEN-END:|36-getter|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Getter: txtNo ">//GEN-BEGIN:|37-getter|0|37-preInit
   /**
    * Returns an initiliazed instance of txtNo component.
    * @return the initialized component instance
    */
   public TextField getTxtNo() {
       if (txtNo == null) {//GEN-END:|37-getter|0|37-preInit
            // write pre-init user code here
           txtNo = new TextField("Office No.", null, 32, TextField.ANY);//GEN-LINE:|37-getter|1|37-postInit
            // write post-init user code here
       }//GEN-BEGIN:|37-getter|2|
       return txtNo;
   }
   //</editor-fold>//GEN-END:|37-getter|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand1 ">//GEN-BEGIN:|28-getter|0|28-preInit
   /**
    * Returns an initiliazed instance of okCommand1 component.
    * @return the initialized component instance
    */
   public Command getOkCommand1() {
       if (okCommand1 == null) {//GEN-END:|28-getter|0|28-preInit
            // write pre-init user code here
           okCommand1 = new Command("Ok", Command.OK, 0);//GEN-LINE:|28-getter|1|28-postInit
            // write post-init user code here
       }//GEN-BEGIN:|28-getter|2|
       return okCommand1;
   }
   //</editor-fold>//GEN-END:|28-getter|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Getter: saveInstructor ">//GEN-BEGIN:|33-getter|0|33-preInit
   /**
    * Returns an initiliazed instance of saveInstructor component.
    * @return the initialized component instance
    */
   public Command getSaveInstructor() {
       if (saveInstructor == null) {//GEN-END:|33-getter|0|33-preInit
            // write pre-init user code here
           saveInstructor = new Command("Save", Command.OK, 0);//GEN-LINE:|33-getter|1|33-postInit
            // write post-init user code here
       }//GEN-BEGIN:|33-getter|2|
       return saveInstructor;
   }
   //</editor-fold>//GEN-END:|33-getter|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Getter: FindRoom ">//GEN-BEGIN:|41-getter|0|41-preInit
   /**
    * Returns an initiliazed instance of FindRoom component.
    * @return the initialized component instance
    */
   public Form getFindRoom() {
       if (FindRoom == null) {//GEN-END:|41-getter|0|41-preInit
            // write pre-init user code here
           FindRoom = new Form("Find Room", new Item[] { getTxtFind(), getShowFound() });//GEN-BEGIN:|41-getter|1|41-postInit
           FindRoom.addCommand(getExitFindRoom());
           FindRoom.addCommand(getGetRoom());
           FindRoom.setCommandListener(this);//GEN-END:|41-getter|1|41-postInit
            // write post-init user code here
       }//GEN-BEGIN:|41-getter|2|
       return FindRoom;
   }
   //</editor-fold>//GEN-END:|41-getter|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitFindRoom ">//GEN-BEGIN:|42-getter|0|42-preInit
   /**
    * Returns an initiliazed instance of exitFindRoom component.
    * @return the initialized component instance
    */
   public Command getExitFindRoom() {
       if (exitFindRoom == null) {//GEN-END:|42-getter|0|42-preInit
            // write pre-init user code here
           exitFindRoom = new Command("Back", Command.EXIT, 0);//GEN-LINE:|42-getter|1|42-postInit
            // write post-init user code here
       }//GEN-BEGIN:|42-getter|2|
       return exitFindRoom;
   }
   //</editor-fold>//GEN-END:|42-getter|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Getter: getRoom ">//GEN-BEGIN:|45-getter|0|45-preInit
   /**
    * Returns an initiliazed instance of getRoom component.
    * @return the initialized component instance
    */
   public Command getGetRoom() {
       if (getRoom == null) {//GEN-END:|45-getter|0|45-preInit
            // write pre-init user code here
           getRoom = new Command("Find", Command.OK, 0);//GEN-LINE:|45-getter|1|45-postInit
            // write post-init user code here
       }//GEN-BEGIN:|45-getter|2|
       return getRoom;
   }
   //</editor-fold>//GEN-END:|45-getter|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Getter: txtFind ">//GEN-BEGIN:|47-getter|0|47-preInit
   /**
    * Returns an initiliazed instance of txtFind component.
    * @return the initialized component instance
    */
   public TextField getTxtFind() {
       if (txtFind == null) {//GEN-END:|47-getter|0|47-preInit
            // write pre-init user code here
           txtFind = new TextField("Enter The Number Of The Room", null, 32, TextField.ANY);//GEN-LINE:|47-getter|1|47-postInit
            // write post-init user code here
       }//GEN-BEGIN:|47-getter|2|
       return txtFind;
   }
   //</editor-fold>//GEN-END:|47-getter|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem ">//GEN-BEGIN:|48-getter|0|48-preInit
   /**
    * Returns an initiliazed instance of stringItem component.
    * @return the initialized component instance
    */
   public StringItem getStringItem() {
       if (stringItem == null) {//GEN-END:|48-getter|0|48-preInit
            // write pre-init user code here
           stringItem = new StringItem("", null);//GEN-LINE:|48-getter|1|48-postInit
            // write post-init user code here
       }//GEN-BEGIN:|48-getter|2|
       return stringItem;
   }
   //</editor-fold>//GEN-END:|48-getter|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Getter: newRecord ">//GEN-BEGIN:|49-getter|0|49-preInit
   /**
    * Returns an initiliazed instance of newRecord component.
    * @return the initialized component instance
    */
   public Command getNewRecord() {
       if (newRecord == null) {//GEN-END:|49-getter|0|49-preInit
            // write pre-init user code here
           newRecord = new Command("Add New Record", Command.OK, 0);//GEN-LINE:|49-getter|1|49-postInit
            // write post-init user code here
       }//GEN-BEGIN:|49-getter|2|
       return newRecord;
   }
   //</editor-fold>//GEN-END:|49-getter|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Getter: showFound ">//GEN-BEGIN:|51-getter|0|51-preInit
   /**
    * Returns an initiliazed instance of showFound component.
    * @return the initialized component instance
    */
   public StringItem getShowFound() {
       if (showFound == null) {//GEN-END:|51-getter|0|51-preInit
            // write pre-init user code here
           showFound = new StringItem("", null);//GEN-LINE:|51-getter|1|51-postInit
            // write post-init user code here
       }//GEN-BEGIN:|51-getter|2|
       return showFound;
   }
   //</editor-fold>//GEN-END:|51-getter|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Getter: drawRoom ">//GEN-BEGIN:|52-getter|0|52-preInit
   /**
    * Returns an initiliazed instance of drawRoom component.
    * @return the initialized component instance
    */
   public Form getDrawRoom() {
       if (drawRoom == null) {//GEN-END:|52-getter|0|52-preInit
            // write pre-init user code here
           drawRoom = new Form("Room Map", new Item[] { getTxtMap() });//GEN-BEGIN:|52-getter|1|52-postInit
           drawRoom.addCommand(getExitCommand1());
           drawRoom.setCommandListener(this);//GEN-END:|52-getter|1|52-postInit
            // write post-init user code here
       }//GEN-BEGIN:|52-getter|2|
       return drawRoom;
   }
   //</editor-fold>//GEN-END:|52-getter|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand1 ">//GEN-BEGIN:|53-getter|0|53-preInit
   /**
    * Returns an initiliazed instance of exitCommand1 component.
    * @return the initialized component instance
    */
   public Command getExitCommand1() {
       if (exitCommand1 == null) {//GEN-END:|53-getter|0|53-preInit
            // write pre-init user code here
           exitCommand1 = new Command("Exit", Command.BACK, 0);//GEN-LINE:|53-getter|1|53-postInit
            // write post-init user code here
       }//GEN-BEGIN:|53-getter|2|
       return exitCommand1;
   }
   //</editor-fold>//GEN-END:|53-getter|2|



   //<editor-fold defaultstate="collapsed" desc=" Generated Getter: txtMap ">//GEN-BEGIN:|58-getter|0|58-preInit
   /**
    * Returns an initiliazed instance of txtMap component.
    * @return the initialized component instance
    */
   public TextField getTxtMap() {
       if (txtMap == null) {//GEN-END:|58-getter|0|58-preInit
            // write pre-init user code here
           txtMap = new TextField("", null, 32, TextField.ANY);//GEN-LINE:|58-getter|1|58-postInit
            // write post-init user code here
       }//GEN-BEGIN:|58-getter|2|
       return txtMap;
   }
   //</editor-fold>//GEN-END:|58-getter|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Getter: allLevel ">//GEN-BEGIN:|62-getter|0|62-preInit
   /**
    * Returns an initiliazed instance of allLevel component.
    * @return the initialized component instance
    */
   public Form getAllLevel() {
       if (allLevel == null) {//GEN-END:|62-getter|0|62-preInit
            // write pre-init user code here
           allLevel = new Form("All Rooms in Floor", new Item[] { getTxtLevel() });//GEN-BEGIN:|62-getter|1|62-postInit
           allLevel.addCommand(getBackCommand());
           allLevel.addCommand(getOkCommandLevel());
           allLevel.setCommandListener(this);//GEN-END:|62-getter|1|62-postInit
            // write post-init user code here
       }//GEN-BEGIN:|62-getter|2|
       return allLevel;
   }
   //</editor-fold>//GEN-END:|62-getter|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|63-getter|0|63-preInit
   /**
    * Returns an initiliazed instance of backCommand component.
    * @return the initialized component instance
    */
   public Command getBackCommand() {
       if (backCommand == null) {//GEN-END:|63-getter|0|63-preInit
            // write pre-init user code here
           backCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|63-getter|1|63-postInit
            // write post-init user code here
       }//GEN-BEGIN:|63-getter|2|
       return backCommand;
   }
   //</editor-fold>//GEN-END:|63-getter|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommandLevel ">//GEN-BEGIN:|66-getter|0|66-preInit
   /**
    * Returns an initiliazed instance of okCommandLevel component.
    * @return the initialized component instance
    */
   public Command getOkCommandLevel() {
       if (okCommandLevel == null) {//GEN-END:|66-getter|0|66-preInit
            // write pre-init user code here
           okCommandLevel = new Command("Ok", Command.OK, 0);//GEN-LINE:|66-getter|1|66-postInit
            // write post-init user code here
       }//GEN-BEGIN:|66-getter|2|
       return okCommandLevel;
   }
   //</editor-fold>//GEN-END:|66-getter|2|



   //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand3 ">//GEN-BEGIN:|70-getter|0|70-preInit
   /**
    * Returns an initiliazed instance of okCommand3 component.
    * @return the initialized component instance
    */
   public Command getOkCommand3() {
       if (okCommand3 == null) {//GEN-END:|70-getter|0|70-preInit
            // write pre-init user code here
           okCommand3 = new Command("Ok", Command.OK, 0);//GEN-LINE:|70-getter|1|70-postInit
            // write post-init user code here
       }//GEN-BEGIN:|70-getter|2|
       return okCommand3;
   }
   //</editor-fold>//GEN-END:|70-getter|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Getter: txtLevel ">//GEN-BEGIN:|71-getter|0|71-preInit
   /**
    * Returns an initiliazed instance of txtLevel component.
    * @return the initialized component instance
    */
   public TextField getTxtLevel() {
       if (txtLevel == null) {//GEN-END:|71-getter|0|71-preInit
            // write pre-init user code here
           txtLevel = new TextField("Enter The Level", null, 32, TextField.ANY);//GEN-LINE:|71-getter|1|71-postInit
            // write post-init user code here
       }//GEN-BEGIN:|71-getter|2|
       return txtLevel;
   }
   //</editor-fold>//GEN-END:|71-getter|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Getter: allEmpty ">//GEN-BEGIN:|72-getter|0|72-preInit
   /**
    * Returns an initiliazed instance of allEmpty component.
    * @return the initialized component instance
    */
   public Form getAllEmpty() {
       if (allEmpty == null) {//GEN-END:|72-getter|0|72-preInit
            // write pre-init user code here
           allEmpty = new Form("Empty Rooms");//GEN-BEGIN:|72-getter|1|72-postInit
           allEmpty.addCommand(getOkCommandEmpty());
           allEmpty.addCommand(getBackCommand1());
           allEmpty.setCommandListener(this);//GEN-END:|72-getter|1|72-postInit
            // write post-init user code here
       }//GEN-BEGIN:|72-getter|2|
       return allEmpty;
   }
   //</editor-fold>//GEN-END:|72-getter|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommandEmpty ">//GEN-BEGIN:|73-getter|0|73-preInit
   /**
    * Returns an initiliazed instance of okCommandEmpty component.
    * @return the initialized component instance
    */
   public Command getOkCommandEmpty() {
       if (okCommandEmpty == null) {//GEN-END:|73-getter|0|73-preInit
            // write pre-init user code here
           okCommandEmpty = new Command("Get Empty Rooms", Command.OK, 0);//GEN-LINE:|73-getter|1|73-postInit
            // write post-init user code here
       }//GEN-BEGIN:|73-getter|2|
       return okCommandEmpty;
   }
   //</editor-fold>//GEN-END:|73-getter|2|

   //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand1 ">//GEN-BEGIN:|75-getter|0|75-preInit
   /**
    * Returns an initiliazed instance of backCommand1 component.
    * @return the initialized component instance
    */
   public Command getBackCommand1() {
       if (backCommand1 == null) {//GEN-END:|75-getter|0|75-preInit
            // write pre-init user code here
           backCommand1 = new Command("Back", Command.BACK, 0);//GEN-LINE:|75-getter|1|75-postInit
            // write post-init user code here
       }//GEN-BEGIN:|75-getter|2|
       return backCommand1;
   }
   //</editor-fold>//GEN-END:|75-getter|2|

    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay () {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable (null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
//        Displayable d = new PacerCanvas();
        

        try {
            createRecord();

        } catch (Exception e) {
        }

        try {
            createRecord();
        } catch (Exception e) {
        }
        if (midletPaused) {
            resumeMIDlet ();
        } else {
            initialize ();
            startMIDlet ();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }

}
/////////////////////////////////////
class PacerCanvas extends Canvas{
    public String strRoomNo,strTelNo,strName;
    private RecordStore rs;
    private static final String STORE_NAME = "Rooms";
    public String roomNo;
    public String insName;
    public String telNo;
    public int levelNo;
    public int choiceNo;


    public PacerCanvas(){
    }

    public PacerCanvas(String strIn){
       strRoomNo = strIn;
       choiceNo = 1;
        try {
            System.out.println("In the Constructor 1");
            createRecord();
            getRecord(strRoomNo);
            getSplit();
        } catch (Exception e) {
        }

    }
    public PacerCanvas(int level){
       levelNo = level;
       choiceNo = 2;
        System.out.println("Int Constructor "+levelNo);
        try {
            System.out.println("In the Constructor 2");
            createRecord();

            getSplit();
        } catch (Exception e) {
        }
    }
        public PacerCanvas(double emp){
        choiceNo = 3;

        try {
            System.out.println("In the Constructor 3");
            createRecord();

            getSplit();
        } catch (Exception e) {
        }
    }
    private void createRecord() throws RecordStoreException{
        rs = RecordStore.openRecordStore(STORE_NAME,true);
        System.out.println("The current number of records: "+ rs.getNumRecords());
        System.out.println("The Name: "+ rs.getName());
    }//createRecored

    public String [] getRecord(String roomNo) throws Exception{
        System.out.println("Inside getRecord "+roomNo);
        String value="";
        int recordSize = 0;
        int index;

        String [] tempValue= new String[rs.getNumRecords()];

        for (index=1;index <= rs.getNumRecords();index++){
            System.out.println("index=getRecord="+ new String(rs.getRecord(index)));
            tempValue[index] = new String(rs.getRecord(index));
            System.out.println("index="+tempValue[index]);
           
        }//for

        return tempValue;


    }//getRecord

    public String [][] getSplit() throws Exception{
        String value;
        String operArr [][] = new String [rs.getNumRecords()][3];
        for (int i = 0;i < rs.getNumRecords(); i++){

                value = new String(rs.getRecord(i+1));

                operArr[i][0] = splitRecord(value, 0, value.length())[0];
                operArr[i][1] = splitRecord(value, 0, value.length())[1];
                operArr[i][2] = splitRecord(value, 0, value.length())[2];
                System.out.println("getSplit "+ operArr[i][0] );
                System.out.println("getSplit "+ operArr[i][1] );
                System.out.println("getSplit "+ operArr[i][2] );
            //}
        }
        return operArr;
    }//get Split
    public String [] splitRecord(String s,int n,int m)
   {
        String temp [] = new String[3];
		String a="",b="",c="";
   		int count1=0,count2=0,count3=0;
   		if(s.equals("")) return null;
	   	for(int i=0;i<s.length();i++)
	   	{
            count2++;
            if (s.substring(i, i+1).equals(":")){
                count1++;
            }
            else{
                if (count1 <1){
                    a+= s.substring(i, i+1);
                }
                else if(count1 == 1){
                    b+= s.substring(i, i+1);
                }
                else{
                    c+= s.substring(i, i+1);
                }
            }

         }//for
           System.out.println("a::"+a+" b::"+b+" c::"+c);
           temp[0]= a;
           temp[1]= b;
           temp[2]= c;
	   	return temp;
  }//split
  public void paint(Graphics g){

  if (choiceNo == 1) {
          System.out.println("Inside paint first");
          int w = getWidth();
          int h = getHeight();
          g.setColor(25, 12, 217);
          g.fillRect(0, 0, w, h);
    g.setColor(0, 255, 255);
      try {
          System.out.println("The Arr first G " + getSplit().length);
          String [][] paintArr = new String [rs.getNumRecords()][3] ;
            paintArr = getSplit();

      
     for (int i =0 ; i <paintArr.length;i++){
        // for (int j = 0; j < paintArr[i].length;j++){
            //System.out.println("The Paint Arr = " + paintArr[i][j]);

            if (strRoomNo.equals(paintArr[i][0])){
                g.drawRect(30, 50*(3) - 30, 150, 50);
                g.drawString("Room: " + paintArr[i][0]  ,35, (3)*50 -15 ,Graphics.LEFT | Graphics.BOTTOM);
                g.drawString("Name: " + paintArr[i][1],35, (3)*50  ,Graphics.LEFT | Graphics.BOTTOM);
                g.drawString("Tel: " + paintArr[i][2],35, (3)*50 +15 ,Graphics.LEFT | Graphics.BOTTOM);
            }
         //}
            if ((Integer.parseInt(paintArr[i][0])-1)==Integer.parseInt(strRoomNo)){
                g.drawRect(30, 50*(2) - 30, 150, 50);
                g.drawString("Room: " + paintArr[i][0]  ,35, (2)*50 -15 ,Graphics.LEFT | Graphics.BOTTOM);
                g.drawString("Name: " + paintArr[i][1],35, (2)*50  ,Graphics.LEFT | Graphics.BOTTOM);
                g.drawString("Tel: " + paintArr[i][2],35, (2)*50 +15 ,Graphics.LEFT | Graphics.BOTTOM);
            }

            if ((Integer.parseInt(paintArr[i][0])-2)==Integer.parseInt(strRoomNo)){
                g.drawRect(30, 50*(1) - 30, 150, 50);
                g.drawString("Room: " + paintArr[i][0]  ,35, (1)*50 -15 ,Graphics.LEFT | Graphics.BOTTOM);
                g.drawString("Name: " + paintArr[i][1],35, (1)*50  ,Graphics.LEFT | Graphics.BOTTOM);
                g.drawString("Tel: " + paintArr[i][2],35, (1)*50 +15 ,Graphics.LEFT | Graphics.BOTTOM);
            }
            if ((Integer.parseInt(paintArr[i][0])+1)==Integer.parseInt(strRoomNo)){
                g.drawRect(30, 50*(4) - 30, 150, 50);
                g.drawString("Room: " + paintArr[i][0]  ,35, (4)*50 -15 ,Graphics.LEFT | Graphics.BOTTOM);
                g.drawString("Name: " + paintArr[i][1],35, (4)*50  ,Graphics.LEFT | Graphics.BOTTOM);
                g.drawString("Tel: " + paintArr[i][2],35, (4)*50 +15 ,Graphics.LEFT | Graphics.BOTTOM);
            }

            if ((Integer.parseInt(paintArr[i][0])+2)==Integer.parseInt(strRoomNo)){
                g.drawRect(30, 50*(5) - 30, 150, 50);
                g.drawString("Room: " + paintArr[i][0]  ,35, (5)*50 -15 ,Graphics.LEFT | Graphics.BOTTOM);
                g.drawString("Name: " + paintArr[i][1],35, (5)*50  ,Graphics.LEFT | Graphics.BOTTOM);
                g.drawString("Tel: " + paintArr[i][2],35, (5)*50 +15 ,Graphics.LEFT | Graphics.BOTTOM);
            }


     }
    } catch (Exception e) {
          System.out.println("Inside Catch " + e.getMessage());
      }


  }//if choiceNo == 1
  if (choiceNo == 2){
          System.out.println("Inside paint Second");
          int w = getWidth();
          int h = getHeight();
          g.setColor(25, 12, 217);
          g.fillRect(0, 0, w, h);
    g.setColor(0, 255, 255);
      try {
          System.out.println("The Arr first G " + getSplit().length);
          String [][] paintArr = new String [rs.getNumRecords()][3] ;
            paintArr = getSplit();

     int counter=0;
     for (int i =0 ; i <paintArr.length;i++){
         
        if (Integer.parseInt(paintArr[i][0].substring(0, 1)) == levelNo){
            System.out.println("Chat@0:"+paintArr[i][0].substring(0, 1)+": The levelNo:"+levelNo+":");
            
            g.drawRect(30, 50*(counter+1) - 30, 150, 50);
            g.drawString("Room: " + paintArr[i][0]  ,35, (counter+1)*50 -15 ,Graphics.LEFT | Graphics.BOTTOM);
            g.drawString("Name: " + paintArr[i][1],35, (counter+1)*50  ,Graphics.LEFT | Graphics.BOTTOM);
            g.drawString("Tel: " + paintArr[i][2],35, (counter+1)*50 +15 ,Graphics.LEFT | Graphics.BOTTOM);
            counter+=1;
        }
     }
     //counter=0;
    } catch (Exception e) {
          System.out.println("Inside Catch " + e.getMessage());
      }
      
  }//if choiceNo ==2
  if (choiceNo == 3){
          System.out.println("Inside paint Second");
          int w = getWidth();
          int h = getHeight();
          g.setColor(25, 12, 217);
          g.fillRect(0, 0, w, h);
          g.setColor(0, 255, 255);
      try {
          System.out.println("The Arr first G " + getSplit().length);
          String [][] paintArr = new String [rs.getNumRecords()][3] ;
            paintArr = getSplit();

     int counter=0;
     for (int i =0 ; i <paintArr.length;i++){

        if (paintArr[i][1].toString().equals("empty")){
           
            g.drawRect(30, 50*(counter+1) - 30, 150, 50);
            g.drawString("Room: " + paintArr[i][0]  ,35, (counter+1)*50 -15 ,Graphics.LEFT | Graphics.BOTTOM);
            g.drawString("Name: " + paintArr[i][1],35, (counter+1)*50  ,Graphics.LEFT | Graphics.BOTTOM);
            g.drawString("Tel: " + paintArr[i][2],35, (counter+1)*50 +15 ,Graphics.LEFT | Graphics.BOTTOM);
            counter+=1;
        }
     }
     //counter=0;
    } catch (Exception e) {
          System.out.println("Inside Catch " + e.getMessage());
      }

  }//if choiceNo ==2
  }
}

