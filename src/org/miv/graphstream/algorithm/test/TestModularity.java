/*
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 */

package org.miv.graphstream.algorithm.test;

import java.io.*;

import org.miv.graphstream.io.*;
import org.miv.graphstream.graph.*;
import org.miv.graphstream.graph.implementations.DefaultGraph;

/**
 * Test the Newman and Girvan Modularity measure.
 *
 * @author Antoine Dutot
 * @author Yoann Pign�
 * @since 2007
 */
public class TestModularity
{
	public static void main( String args[] )
	{
		if( args.length > 1 )
		{
			try
			{
				new TestModularity( args[0], args[1] );
			}
			catch( IOException e )
			{
				e.printStackTrace();
			}
			catch( GraphParseException e )
			{
				e.printStackTrace();
			}
		}
	}
	
	public TestModularity( String graphFileName, String marker )
		throws IOException, GraphParseException
	{
		Graph       g  = new DefaultGraph();
		
		g.read( graphFileName );

		float Q = g.algorithm().modularity( marker );
		
		System.err.printf( "%n%nModularity: %f%n%n", Q );
	}
}