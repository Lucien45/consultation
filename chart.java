public void showHistogram(){
		double[] values = {	95,49,14,59,50,66,47,40,1,67,
				12,58,28,63,14,9,31,17,94,71,
				49,64,73,97,15,63,10,12,31,62,
				93,49,74,90,59,14,15,88,26,57,
				77,44,58,91,10,67,57,19,88,84
		};
		HistogramDataset dataset = new HistogramDataset();
		dataset.addSeries("key", values, 20);
		
		JFreeChart chart = ChartFactory.createHistogram("JFreeChart Histogram", "Data", "Frequency", dataset, PlotOrientation.VERTICAL, false, true, false);
		XYPlot plot = chart.getXYPlot();
		plot.setBackgroundPaint(Color.WHITE);
		
		ChartPanel barpChartPanel2 = new ChartPanel(chart);
		panelHistogram.removeAll();
		panelHistogram.add(barpChartPanel2, BorderLayout.CENTER);
		panelHistogram.validate();	
	}
	
	public void showHistogram1(){
		String rq = "select * from code";
		try {
			 st=con.getConn().createStatement();
			 rst=st.executeQuery(rq);
			  List<Double> dbValues = new ArrayList<>();
			 while(rst.next()){
				 double value = rst.getDouble("caractere");
                 dbValues.add(value);
			 } 
			 
			 double[] dbArray = new double[dbValues.size()];
             for (int i = 0; i < dbValues.size(); i++) {
                 dbArray[i] = dbValues.get(i);
                 System.out.println(dbValues.get(i));
             }
             
             HistogramDataset dataset = new HistogramDataset();
             dataset.addSeries("key", dbArray, 20);
             
             JFreeChart chart = ChartFactory.createHistogram("JFreeChart Histogram", "Data", "Frequency", dataset, PlotOrientation.VERTICAL, false, true, false);
     		XYPlot plot = chart.getXYPlot();
     		plot.setBackgroundPaint(Color.WHITE);
     		
     		ChartPanel barpChartPanel2 = new ChartPanel(chart);
     		panelHistogram.removeAll();
     		panelHistogram.add(barpChartPanel2, BorderLayout.CENTER);
     		panelHistogram.validate();	
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
		
	public void showBarChart(){
		/*create dataset for the graph*/
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(200,"Amount", "january");
		dataset.setValue(150,"Amount", "february");
		dataset.setValue(18,"Amount", "march");
		dataset.setValue(100,"Amount", "april");
		dataset.setValue(80,"Amount", "may");
		dataset.setValue(250,"Amount", "june");

		/*create chart*/
		JFreeChart chart = ChartFactory.createBarChart("contribution","monthly","amount",
			dataset, PlotOrientation.VERTICAL, false,true,false);

		/*create plot object*/
		CategoryPlot categoryPlot = chart.getCategoryPlot();
		categoryPlot.setBackgroundPaint(Color.white);

		/*create render object to change the moficy the line propreties like color*/
		BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
		Color clr3 = new Color(204,0,51);
		renderer.setSeriesPaint(0, clr3);

		/*create chartPanel to display chart(graph) */ 
		ChartPanel barpChartPanel = new ChartPanel(chart);
//		panelBarChart.removeAll();
//		panelBarChart.add(barpChartPanel, BorderLayout.CENTER);
//		panelBarChart.validate();
	}
	@SuppressWarnings("removal")
	public void showPieChart(){
		/*create dataset*/
		DefaultPieDataset barDataset = new DefaultPieDataset();
		barDataset.setValue("IPhone 5s", new Double(20));
		barDataset.setValue("SamSung Grand", new Double(20));
		barDataset.setValue("MotoG", new Double(40));
		barDataset.setValue("Nokia Lumia", new Double(10));

		/*create chart*/
		JFreeChart piechart = ChartFactory.createPieChart("mobile sales", barDataset, false, true, false);
		PiePlot piePlot = (PiePlot) piechart.getPlot();

		/*changing pie chart blocks colors*/
		piePlot.setSectionPaint("Iphone 5s", new Color(255,255,102));
		piePlot.setSectionPaint("SamSung Grand", new Color(102,255,102));
		piePlot.setSectionPaint("MotoG", new Color(255,102,153));
		piePlot.setSectionPaint("Nokia Lumia", new Color(0,202,204));

		piePlot.setBackgroundPaint(Color.white);

		/*create chartPanel to display chart(graph)*/
		ChartPanel barChartPanel = new ChartPanel(piechart);
		panelPieChart.removeAll();
		panelPieChart.add(barChartPanel, BorderLayout.CENTER);
		panelPieChart.validate();
	}
	
	public void showLineChart(){
		/*create dataset for the graph*/
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(200,"Amount", "january");
		dataset.setValue(150,"Amount", "february");
		dataset.setValue(18,"Amount", "march");
		dataset.setValue(100,"Amount", "april");
		dataset.setValue(80,"Amount", "may");
		dataset.setValue(250,"Amount", "june");

		/*create chart*/
		JFreeChart linechart = ChartFactory.createLineChart("contribution","monthly","amount",
				dataset, PlotOrientation.VERTICAL, false,true,false);

		/*create plot object*/
		CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();

		lineCategoryPlot.setBackgroundPaint(Color.white);

		/*create render object to change the moficy the line propreties like color*/
		LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
		Color lineChartColor = new Color(204,0,51);
		lineRenderer.setSeriesPaint(0, lineChartColor);

		/*create chartPanel to display chart(graph) */ 
		ChartPanel lineChartPanel = new ChartPanel(linechart);
		panellineChart.removeAll();
		panellineChart.add(lineChartPanel, BorderLayout.CENTER);
		panellineChart.validate();
	}