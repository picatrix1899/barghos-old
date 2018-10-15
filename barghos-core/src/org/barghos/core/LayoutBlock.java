package org.barghos.core;

import java.util.ArrayList;

public class LayoutBlock
{
	private ArrayList<ILayoutedBlock> blocks = new ArrayList<ILayoutedBlock>();
	
	private int maxLineWidth;
	
	private String borderLR;
	private String borderTB;
	private String borderEdgeT;
	private String borderEdgeB;
}
