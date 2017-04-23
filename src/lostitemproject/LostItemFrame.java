/* 
 * To change this license header, choose License Headers in Project Properties. 
 * To change this template file, choose Tools | Templates 
 * and open the template in the editor. 
 */ 
package lostitemproject; 
 
import java.awt.*; 
import java.sql.*; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
import javax.swing.*; 
 
/** 
 * 
 * @author POOM 
 */ 
public class LostItemFrame extends javax.swing.JFrame { 
    private LoginGUI loginPage; 
    private ViewLostItemGUI viewPage; 
    private AddLostItemGUI addItemPage; 
    private ViewDetailGUI detailPage;
    private Account user; 
    private LostItem focusItem; 
     
    public LostItemFrame() { 
        this.setSize(860, 590); 
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setLocationRelativeTo(null); 
        toLoginPage(); 
    } 
     
    public void toLoginPage(){ 
        this.getContentPane().removeAll(); 
        loginPage = new LoginGUI(); 
        loginPage.getLoginBtn().addActionListener(new ChangePanelListener(this,ChangePanelListener.LOGIN)); 
        this.add(loginPage); 
        this.repaint(); 
        this.revalidate(); 
    } 
     
    public void toViewPage(){ 
        try { 
            this.getContentPane().removeAll(); 
            viewPage = new ViewLostItemGUI(user); 
            viewPage.getLogoutBtn().addActionListener(new ChangePanelListener(this,ChangePanelListener.LOGOUT));
            viewPage.getAddLostItembtn().addActionListener(new ChangePanelListener(this,ChangePanelListener.ADD_LOSTITEM));
            EachItemGUI[] allItemShow = viewPage.getAllItemShow();
            for(int i=0;i<allItemShow.length;i++){
                allItemShow[i].getViewDetailBtn().addActionListener(new ChangePanelListener(this,ChangePanelListener.DETAIL,allItemShow[i].getItem())); 
            }
            this.add(viewPage);
            this.repaint(); 
            this.revalidate(); 
             
        } catch (InterruptedException ex) { 
            Logger.getLogger(LostItemFrame.class.getName()).log(Level.SEVERE, null, ex); 
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(LostItemFrame.class.getName()).log(Level.SEVERE, null, ex); 
        } catch (SQLException ex) { 
            Logger.getLogger(LostItemFrame.class.getName()).log(Level.SEVERE, null, ex); 
        } 
         
    } 
     
    public void toAddItemPage(){
        this.getContentPane().removeAll(); 
        addItemPage = new AddLostItemGUI(user); 
        this.add(addItemPage); 
        addItemPage.getBackBtn().addActionListener(new ChangePanelListener(this,ChangePanelListener.BACKTO_HOMEPAGE));
        addItemPage.getBtnConfirm().addActionListener(new ChangePanelListener(this,ChangePanelListener.CONFIRM_ADDITEM));
        this.repaint(); 
        this.revalidate(); 
    }
    
    public void toDetailPage(){
//        System.out.println("Focus item : "+focusItem);
        this.getContentPane().removeAll(); 
        detailPage = new ViewDetailGUI(focusItem,user);
        this.add(detailPage); 
        detailPage.getBackBtn().addActionListener(new ChangePanelListener(this,ChangePanelListener.BACKTO_HOMEPAGE));
//        addItemPage.getBtnConfirm().addActionListener(new ChangePanelListener(this,ChangePanelListener.CONFIRM_ADDITEM));
        this.repaint(); 
        this.revalidate(); 
    }
     
    public LoginGUI getLoginPage() { 
        return loginPage; 
    } 
 
    public void setLoginPage(LoginGUI loginPage) { 
        this.loginPage = loginPage; 
    } 
 
    public ViewLostItemGUI getViewPage() { 
        return viewPage; 
    } 
 
    public void setViewPage(ViewLostItemGUI viewPage) { 
        this.viewPage = viewPage; 
    } 
 
    public AddLostItemGUI getAddItemPage() { 
        return addItemPage; 
    } 
 
    public void setAddItemPage(AddLostItemGUI addItemPage) { 
        this.addItemPage = addItemPage; 
    } 
 
    public Account getUser() { 
        return user; 
    } 
 
    public void setUser(Account user) { 
        this.user = user; 
    } 
 
    public LostItem getFocusItem() { 
        return focusItem; 
    } 
 
    public void setFocusItem(LostItem focusItem) { 
        this.focusItem = focusItem; 
    } 

    public ViewDetailGUI getDetailPage() {
        return detailPage;
    }

    public void setDetailPage(ViewDetailGUI detailPage) {
        this.detailPage = detailPage;
    }
     
     
     
}