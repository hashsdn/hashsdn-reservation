/*
 * Copyright (c) 2015 Inocybe Technologies, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.reservation.tl1.library.message;


/**
 * TL1 Line from Payload response
 *
 * @author Mathieu Lemay
 * @version 1.0.0a
 */
public class TL1Line {
    /** TL1 Sections in this Line */

    private TL1Section[] sections;
    public TL1Line(){

    }
    /**
     * Creates a new instance of TL1Line
     *
     * @param line
     *            Raw TL1 Line Data String to parse
     */
    public TL1Line(String line) {
    	//Remove quotes
        if (line.charAt(0) == '"' && line.charAt(line.length() - 1) == '"')
            line = line.substring(1, line.length() - 1);

        String[] splitLine = line.split(":", -1);
        sections = new TL1Section[splitLine.length];
        for(int i=0; i<splitLine.length; i++) {
        	sections[i] = new TL1Section(splitLine[i]);
        }

    }

    /**
     * Returns an array of the TL1 sections from that line
     *
     * @return Array of TL1Section
     */
    public TL1Section[] getSections() {
        return sections;
    }

    /**
     * Gets a specific section on the line
     *
     * @param index
     *            index of the section to get.
     * @return Section in TL1Section format
     */
    public TL1Section getSection(int index) {
        return sections[index];
    }

    /**
     * Convert a Tl1Line to a String
     */
    public String toString() {
        StringBuffer s = new StringBuffer();
        for(int i=0; i<sections.length; i++) {
            s.append(sections[i].toString());
            if(i < sections.length - 1)
                s.append(":");
        }
        return s.toString();
    }

    public void setSections(TL1Section[] sections)
    {
        this.sections = sections;
    }
}

