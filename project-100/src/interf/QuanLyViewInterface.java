package interf;

import java.awt.event.ActionListener;


public interface QuanLyViewInterface {
    void addQuanlySVButtonListener(ActionListener listener);
    void addQuanlyMHButtonListener(ActionListener listener);
    void addXoaButtonListener(ActionListener listener);
    void setVisible(boolean visible);
    void dispose();
}
