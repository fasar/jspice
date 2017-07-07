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
package org.knowm.jspice.transientanalysis.driver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.knowm.jspice.simulate.transientanalysis.driver.Driver;
import org.knowm.jspice.simulate.transientanalysis.driver.Pulse;

/**
 * @author timmolter
 */
public class TestPulseDriver extends TestDrivers {

  /**
   * @param args
   */
  public static void main(String[] args) {

    TestPulseDriver testDrivers = new TestPulseDriver();
    testDrivers.test();
  }

  @Test
  public void test() {

    Driver driver = new Pulse("Pulse", 5, .2, 10, .5, .10); // unit test case

    double stopTime = 2;
    double timeStep = .01;

    List<Number> xData = new ArrayList<Number>();
    List<Number> yData = new ArrayList<Number>();

    double firstPoint = 0.0;
    for (double i = firstPoint; i <= stopTime + timeStep; i = i + timeStep) {
      if (counter == point2Verify) {
        y = driver.getSignal(i);
      }
      counter++;
      xData.add(i);
      yData.add(driver.getSignal(i));
    }

    // System.out.println(xData);
    // System.out.println(yData);
    // System.out.println(y);

    assertThat(xData.size(), is(equalTo(201)));
    assertThat(y, is(closeTo(-5, .01)));

    //    plotData("V(in)", xData, yData);
  }
}
