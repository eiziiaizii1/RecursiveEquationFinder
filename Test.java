import valueSolverPack.*;

public class Test {
	public static void main(String[] args) {
		System.out.println("Test Case For: Integer Values With Positive Result");
		Value v1 = new IntegerValue(11);
		Value v2 = new IntegerValue(7);
		Value v3 = new IntegerValue(12);
		Value v4 = new IntegerValue(6);
		Value[] arr1 = { v1, v2, v3, v4 };
		Value result1 = new IntegerValue(41);
		RecursiveSolver solver = new RecursiveSolver(arr1, result1);
		System.out.println(solver.findExpression());
		System.out.println("\n-----------------------------------------------------------------------------");

		System.out.println("Test Case For: Integer But Exact Solution Can't Be Found ");
		Value v5 = new IntegerValue(7);
		Value v6 = new IntegerValue(15);
		Value v7 = new IntegerValue(22);
		Value v8 = new IntegerValue(39);
		Value[] arr2 = { v5, v6, v7, v8 };
		Value result2 = new IntegerValue(48);
		RecursiveSolver solver2 = new RecursiveSolver(arr2, result2);
		System.out.println(solver2.findExpression());
		System.out.println("\n-----------------------------------------------------------------------------");

		System.out.println("Test Case For: Single Integer");
		Value v9 = new IntegerValue(5);
		Value[] arr3 = { v9 };
		Value results3 = new IntegerValue(5);
		RecursiveSolver solver3 = new RecursiveSolver(arr3, results3);
		System.out.println(solver3.findExpression());
		System.out.println("\n-----------------------------------------------------------------------------");

		System.out.println("Test Case For: Integer Values With Negative Result");
		Value v10 = new IntegerValue(73902);
		Value v11 = new IntegerValue(3);
		Value v12 = new IntegerValue(221707);
		Value[] arr4 = { v10, v11, v12 };
		Value result4 = new IntegerValue(-1);
		RecursiveSolver solver4 = new RecursiveSolver(arr4, result4);
		System.out.println(solver4.findExpression());
		System.out.println("\n-----------------------------------------------------------------------------");

		System.out.println("Test Case For: One Character String Values");
		Value v13 = new StringValue("R");
		Value v14 = new StringValue("A");
		Value v15 = new StringValue("N");
		Value v16 = new StringValue("A");
		Value[] arr5 = { v13, v14, v15, v16 };
		Value results5 = new StringValue("NAR");
		RecursiveSolver solver5 = new RecursiveSolver(arr5, results5);
		System.out.println(solver5.findExpression());
		System.out.println("\n-----------------------------------------------------------------------------");

		System.out.println("Test Case For: Multi Character String Values");
		Value v17 = new StringValue("KEDIKEBAP");
		Value v18 = new StringValue("E");
		Value v19 = new StringValue("KEDI");
		Value v20 = new StringValue("AN");
		Value[] arr6 = { v17, v18, v19, v20 };
		Value results6 = new StringValue("KEBAP");
		RecursiveSolver solver6 = new RecursiveSolver(arr6, results6);
		System.out.println(solver6.findExpression());
		System.out.println("\n-----------------------------------------------------------------------------");

		System.out.println("Test Case For: Sign Character String Values");
		Value v21 = new StringValue("kopek");
		Value v22 = new StringValue("baliki");
		Value v23 = new StringValue("iki");
		Value v24 = new StringValue("@");
		Value[] arr7 = { v21, v22, v23, v24 };
		Value results7 = new StringValue("b@a@l@k@o@p@e@k@");
		RecursiveSolver solver7 = new RecursiveSolver(arr7, results7);
		System.out.println(solver7.findExpression());
		System.out.println("\n-----------------------------------------------------------------------------");

		System.out.println("Test Case For: Different Type of Values But TargetValue is a StringValue (13 is string)");
		Value v25 = new StringValue("meow");
		Value v26 = new StringValue("13");
		Value v27 = new IntegerValue(9999);
		Value[] arr8 = { v25, v26, v27 };
		Value results8 = new StringValue("Fatih Nar <3");
		RecursiveSolver solver8 = new RecursiveSolver(arr8, results8);
		System.out.println(solver8.findExpression());
		System.out.println("\n-----------------------------------------------------------------------------");

		System.out.println("Test Case For: Month Values");
		Value v28 = new MonthValue(Months.JANUARY);
		Value v29 = new MonthValue(Months.FEBRUARY);
		Value v30 = new MonthValue(Months.APRIL);
		Value[] arr9 = { v28, v29, v30 };
		Value results9 = new MonthValue(Months.JUNE);
		RecursiveSolver solver9 = new RecursiveSolver(arr9, results9);
		System.out.println(solver9.findExpression());
		System.out.println("\n-----------------------------------------------------------------------------");

		System.out.println("Test Case For: Month Values But Exact Solution Can't Be Found ");
		Value v31 = new MonthValue(Months.AUGUST);
		Value v32 = new MonthValue(Months.FEBRUARY);
		Value v33 = new MonthValue(Months.DECEMBER);
		Value[] arr10 = { v31, v32, v33 };
		Value results10 = new MonthValue(Months.MAY);
		RecursiveSolver solver10 = new RecursiveSolver(arr10, results10);
		System.out.println(solver10.findExpression());
		System.out.println("\n-----------------------------------------------------------------------------");

		System.out.println("Test Case For: Month Values But Result Exists In Value Pool");
		Value v34 = new MonthValue(Months.DECEMBER);
		Value v35 = new MonthValue(Months.FEBRUARY);
		Value v36 = new MonthValue(Months.AUGUST);
		Value v37 = new MonthValue(Months.SEPTEMBER);
		Value[] arr11 = { v34, v35, v36,v37 };
		Value results11 = new MonthValue(Months.DECEMBER);
		RecursiveSolver solver11 = new RecursiveSolver(arr11, results11);
		System.out.println(solver11.findExpression());
		System.out.println("\n-----------------------------------------------------------------------------");

		System.out.println("Test Case For: Month Values But TargetValue is January");
		Value v38 = new MonthValue(Months.JUNE);
		Value v39 = new MonthValue(Months.JULY);
		Value v40 = new MonthValue(Months.AUGUST);
		Value[] arr12 = { v38, v39, v40};
		Value results12 = new MonthValue(Months.JANUARY);
		RecursiveSolver solver12 = new RecursiveSolver(arr12, results12);
		System.out.println(solver12.findExpression());
		System.out.println("\n-----------------------------------------------------------------------------");

		System.out.println("Test Case For: Month Values");
		Value v41 = new MonthValue(Months.JANUARY);
		Value v42 = new MonthValue(Months.JULY);
		Value v43 = new MonthValue(Months.FEBRUARY);
		Value v44 = new MonthValue(Months.MAY);
		Value[] arr13 = {v41, v42,v43, v44};
		Value results13 = new MonthValue(Months.APRIL);
		RecursiveSolver solver13 = new RecursiveSolver(arr13, results13);
		System.out.println(solver13.findExpression());
		System.out.println("\n-----------------------------------------------------------------------------");

		System.out.println("Test Case For: Integer Values");
		Value v45 = new IntegerValue(47);
		Value v46 = new IntegerValue(12);
		Value v47 = new IntegerValue(119);
		Value v48 = new IntegerValue(359);
		Value v49 = new IntegerValue(3);
		Value v50 = new IntegerValue(7650);
		Value v51 = new IntegerValue(825);
		Value[] arr14 = {v45, v46, v47, v48, v49, v50, v51,};
		Value results14 = new IntegerValue(333666999);
		RecursiveSolver solver14 = new RecursiveSolver(arr14, results14);
		System.out.println(solver14.findExpression());
		System.out.println("\n-----------------------------------------------------------------------------");

		System.out.println("Test Case For: Multi Character String Values But Exact Solution Does Not Exist");
		Value v52 = new StringValue("ERLANG");
		Value v53 = new StringValue("JAVA");
		Value v54 = new StringValue("PYTHON");
		Value v55 = new StringValue("C");
		Value v56 = new StringValue("CPP");
		Value v57 = new StringValue("SCALA");
		Value[] arr15 = { v52, v53, v54, v55, v56, v57 };
		Value results15 = new StringValue("JAVAPPNAR");
		RecursiveSolver solver15 = new RecursiveSolver(arr15, results15);
		System.out.println(solver15.findExpression());
		System.out.println("\n-----------------------------------------------------------------------------");

		System.out.println("Test Case For: Great Integer Values");
		Value v58 = new IntegerValue(476);
		Value v59 = new IntegerValue(120);
		Value v60 = new IntegerValue(360);
		Value v61 = new IntegerValue(15);
		Value v62 = new IntegerValue(2);
		Value v63 = new IntegerValue(47);
		Value v64 = new IntegerValue(8250);
		Value[] arr16 = {v58, v59, v60, v61, v62, v63, v64 };
		Value results16 = new IntegerValue(5040);
		RecursiveSolver solver16 = new RecursiveSolver(arr16, results16);
		System.out.println(solver16.findExpression());
		System.out.println("\n-----------------------------------------------------------------------------");

		System.out.println("Test Case For: Different Type of Values But TargetValue is a IntegerValue");
		Value v65 = new IntegerValue(33);
		Value v66 = new IntegerValue(67);
		Value v67 = new StringValue("ARABA");
		Value[] arr17 = {null, v65, v66, v67, null};
		Value results17 = new IntegerValue(100);
		RecursiveSolver solver17 = new RecursiveSolver(arr17, results17);
		System.out.println(solver17.findExpression());
		System.out.println("\n-----------------------------------------------------------------------------");

		System.out.println("Test Case For: Different Type of Values But TargetValue is a StringValue");
		Value v68 = new IntegerValue(33);
		Value v69 = new IntegerValue(2);
		Value v70 = new StringValue("AHMET");
		Value v71 = new MonthValue(Months.APRIL);
		Value v72 = new StringValue("HM");
		Value v73 = new IntegerValue(49);
		Value[] arr18 = {null, v68, v69, null, v70, v71, v72, v73, null};
		Value results18 = new StringValue("AETHM");
		RecursiveSolver solver18 = new RecursiveSolver(arr18, results18);
		System.out.println(solver18.findExpression());
		System.out.println("\n-----------------------------------------------------------------------------");

		System.out.println("Test Case For: Empty Pool");
		Value v74 = new StringValue("AHMET");
		Value v75 = new StringValue("HM");
		Value v76 = new MonthValue(Months.AUGUST);
		Value v77 = new IntegerValue(47);
		Value v78 = new IntegerValue(12);
		Value v79 = new IntegerValue(119);
		Value v80 = new IntegerValue(359);
		Value v81 = new IntegerValue(3);
		Value v82 = new IntegerValue(7650);
		Value v83 = new IntegerValue(825);
		Value[] arr19 = {};
		Value results19 = new IntegerValue(5040);
		RecursiveSolver solver19 = new RecursiveSolver(arr19, results19);
		System.out.println(solver19.findExpression());
		System.out.println("\n-----------------------------------------------------------------------------");

		System.out.println("Test Case For: Null Elements");
		Value[] arr20 = {null, null ,null};
		Value results20 = new IntegerValue(30);
		RecursiveSolver solver20 = new RecursiveSolver(arr20, results20);
		System.out.println(solver20.findExpression());
		System.out.println("\n-----------------------------------------------------------------------------");

	}
}
