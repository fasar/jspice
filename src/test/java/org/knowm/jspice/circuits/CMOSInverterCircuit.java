/**
 * jspice is distributed under the GNU General Public License version 3
 * and is also available under alternative licenses negotiated directly
 * with Knowm, Inc.
 *
 * Copyright (c) 2016-2017 Knowm Inc. www.knowm.org
 *
 * Knowm, Inc. holds copyright
 * and/or sufficient licenses to all components of the jspice
 * package, and therefore can grant, at its sole discretion, the ability
 * for companies, individuals, or organizations to create proprietary or
 * open source (even if not GPL) modules which may be dynamically linked at
 * runtime with the portions of jspice which fall under our
 * copyright/license umbrella, or are distributed under more flexible
 * licenses than GPL.
 *
 * The 'Knowm' name and logos are trademarks owned by Knowm, Inc.
 *
 * If you have any questions regarding our licensing policy, please
 * contact us at `contact@knowm.org`.
 */
package org.knowm.jspice.circuits;

import org.knowm.jspice.circuit.Circuit;
import org.knowm.jspice.circuit.subcircuit.CMOSInverter;
import org.knowm.jspice.component.source.DCVoltage;
import org.knowm.jspice.component.source.Source;

/**
 * @author timmolter
 */
public class CMOSInverterCircuit extends Circuit {

  /**
   * Constructor
   */
  public CMOSInverterCircuit() {

    // define voltage source
    Source vDD = new DCVoltage("VDD", 5.0);
    Source vIn = new DCVoltage("Vin", 4);

    // define components
    //    Component rout = new Resistor("Rout", 1000000000);

    // build netlist, the nodes can be named anything except for ground whose node is always labeled "0"
    addNetListComponent(vDD, "Vdd", "0");
    addNetListComponent(vIn, "in", "0");
    //    addNetListComponent(rout, "out", "0");

    addSubCircuit(new CMOSInverter("Vdd", "0", "in", "out", 1.5));
  }
}
