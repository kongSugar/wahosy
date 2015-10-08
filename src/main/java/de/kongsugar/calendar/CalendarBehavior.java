package de.kongsugar.calendar;

import com.sun.javafx.scene.control.behavior.BehaviorBase;
import javafx.scene.control.Control;

import java.util.List;

/**
 * Created by Niko on 07.10.2015.
 */
public class CalendarBehavior extends BehaviorBase {
    /**
     * Create a new BehaviorBase for the given control. The Control must not
     * be null.
     *
     * @param control The control. Must not be null.
     * @param list    The key bindings that should be used with this behavior.
     */
    public CalendarBehavior(Control control, List list) {
        super(control, list);
    }
}
