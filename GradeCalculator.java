/*
 * GradeCalculator.java
 * Author: Emily S. Ockerman
 * Submission Date: September 21, 2018
 *
 * Purpose: If the user enters all of his/her grades and their respective percentages,
 * this program will compute what the student's average is.  If he/she doesn't know 
 * all of his/her grades, it will compute what the user needs to make on future assignments
 * to maintain their grade. 
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing
 * or posting of source code for this project is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia.
 */

import java.util.Scanner;

public class GradeCalculator {
	//enumeration of possible grades
	enum GradeScale {A, B, C, D, F}

	public static void main(String[] args) {

		//preparing for user input
		Scanner input = new Scanner(System.in);

		//printing of the grading scale and prompting user input
		System.out.println("Grading Scale:");
		System.out.println("A\t90 - 100");
		System.out.println("B\t80-89");
		System.out.println("C\t70-79");
		System.out.println("D\t60-69");
		System.out.println("F\tbelow 60");
		System.out.print("What letter grade do you want to achieve for the course?\t");

		//prompting desired grade
		String desiredGrade = input.next();
		if (desiredGrade.equalsIgnoreCase("A") || desiredGrade.equalsIgnoreCase("B") || desiredGrade.equalsIgnoreCase("C") || desiredGrade.equalsIgnoreCase("D") || desiredGrade.equalsIgnoreCase("F"))
		{	
			System.out.println("Enter Percentage Weights:");
		}
		else 
		{
			System.out.println("Input error.");
			System.exit(0);
		}

		//exam one % weight
		System.out.print("Exam 1:\t\t");
		int perExamOne = input.nextInt();

		//exam two % weight
		System.out.print("Exam 2:\t\t");
		int perExamTwo = input.nextInt();

		//final exam % weight
		System.out.print("Final Exam:\t");
		int perFinalExam = input.nextInt();

		//labs % weight
		System.out.print("Labs:\t\t");
		int perLabs = input.nextInt();

		//projects % weight
		System.out.print("Projects:\t");
		int perProjects = input.nextInt();

		//attendance % weight
		System.out.print("Attendance:\t");
		int perAttendance = input.nextInt();

		//quizzes % weight
		System.out.print("Quizzes:\t");
		int perQuizzes = input.nextInt();

		//making sure user cannot validly enter weights that don't add up to 100
		if (perExamOne + perExamTwo + perFinalExam + perLabs + perProjects + perAttendance + perQuizzes == 100) 
		{
			System.out.println("Enter your scores out of a 100:");
			System.out.print("Do you know your Exam 1 score? ");
		}
		else 
		{
			System.out.println("Weights don't add up to 100, program exiting...");
			System.exit(0);
		}

		//declaration and initialization
		int scoreExOne = 0;
		int scoreExTwo = 0;
		int finalExScore = 0;
		int labAv = 0;
		int projAv = 0;
		int quizAv = 0;
		int attAv = 0;
		double finalOverallScore = 0;
		
		//exam one score
		String knowScoreOne = input.next();
		//if user knows exam 1 score
		if (knowScoreOne.equalsIgnoreCase("y") || knowScoreOne.equalsIgnoreCase("yes")) 
		{
			System.out.print("Score received on exam 1: ");
			scoreExOne = input.nextInt();
			//ensure score validity
			if (scoreExOne < 0 || scoreExOne > 100) 
			{
				System.out.println("Invalid grade. Program Exiting...");
				System.exit(0);
			}
			System.out.print("Do you know your Exam 2 score? ");
			//exam two score
			String knowScoreTwo = input.next();
			//they know exam two score
			if (knowScoreTwo.equalsIgnoreCase("y") || knowScoreTwo.equalsIgnoreCase("yes")) 
			{		
				System.out.print("Score received on exam 2: ");
				scoreExTwo = input.nextInt();
				//ensure score validity
				if (scoreExTwo < 0 || scoreExTwo > 100) 
				{
					System.out.println("Invalid grade. Program Exiting...");
					System.exit(0);
				}
				System.out.print("Do you know your Final Exam score? ");
				//final exam score
				String knowFinalExScore = input.next();
				if (knowFinalExScore.equalsIgnoreCase("y") || knowFinalExScore.equalsIgnoreCase("yes")) 
				{
					System.out.print("Score received on final exam: ");
					finalExScore = input.nextInt();
					//ensure score validity
					if (finalExScore < 0 || finalExScore > 100) 
					{
						System.out.println("Invalid grade. Program Exiting...");
						System.exit(0);
					}
					System.out.print("Do you know your lab average? ");
				}
				//don't know final score
				else 
				{
					perFinalExam = 0;
					System.out.print("Do you know your lab average? ");
				}
			}
			//they don't know exam 2 score
			else 
			{
				perExamTwo = 0;
				perFinalExam = 0;
				System.out.print("Do you know your lab average? ");
			}

		}
		//user doesn't know exam 1 score
		else 
		{
			perExamOne = 0;
			perExamTwo = 0;
			perFinalExam = 0;
			System.out.print("Do you know your lab average? ");
		}

		//average lab grade	
		String knowLabAv = input.next();
		if (knowLabAv.equalsIgnoreCase("y") || knowLabAv.equalsIgnoreCase("yes")) 
		{
			System.out.print("Average Lab Grade: ");
			labAv = input.nextInt();
			if (labAv < 0 || labAv > 100) 
			{
				System.out.println("Invalid average. Program Exiting...");
				System.exit(0);
			}
			System.out.print("Do you know your project average? ");
		}
		//don't know average lab grade
		else 
		{
			perLabs = 0;
			System.out.print("Do you know your project average? ");
		}

		//average project grade
		String knowProjAv = input.next();
		if (knowProjAv.equalsIgnoreCase("y") || knowProjAv.equalsIgnoreCase("yes")) 
		{
			System.out.print("Average Project Grade: ");
			projAv = input.nextInt();
			if (projAv < 0 || projAv > 100) 
			{
				System.out.println("Invalid average. Program Exiting...");
				System.exit(0);
			}
			System.out.print("Do you know your quiz average? ");}
		//don't know average project grade
		else 
		{
			perProjects = 0;
			System.out.print("Do you know your quiz average? ");
		}

		//average quiz grade
		String knowQuizAv = input.next();
		if (knowQuizAv.equalsIgnoreCase("y") || knowQuizAv.equalsIgnoreCase("yes")) 
		{
			System.out.print("Average Quiz Grade: ");
			quizAv = input.nextInt();
			if (quizAv < 0 || quizAv > 100) 
			{
				System.out.println("Invalid average. Program Exiting...");
				System.exit(0);
			}
			System.out.print("Do you know your attendace average? ");
		}
		//don't know average quiz grade
		else
		{
			perQuizzes = 0;
			System.out.print("Do you know your attendance average? ");
		}

		//average attendance grade
		String knowAttAv = input.next();
		if (knowAttAv.equalsIgnoreCase("y") || knowAttAv.equalsIgnoreCase("yes")) 
		{
			System.out.print("Average Attendance Grade: ");
			attAv = input.nextInt();
			if (attAv < 0 || attAv > 100) 
			{
				System.out.println("Invalid average. Program Exiting...");
				System.exit(0);
			}
		}
		else
		{
			perAttendance = 0;
		}
	
		//calculating current grade score
		double totalExOne = perExamOne * scoreExOne;
		double totalExTwo = perExamTwo * scoreExTwo;
		double totalFinalEx = perFinalExam * finalExScore;
		double totalLabAv = perLabs * labAv;
		double totalProjAv = perProjects * projAv;
		double totalQuizAv = perQuizzes * quizAv;
		double totalAttAv = perAttendance * attAv;
		double currentScore = (double)(totalExOne + totalExTwo + totalFinalEx + totalLabAv + totalProjAv + totalQuizAv + totalAttAv)/(double)(perExamOne + perExamTwo + perFinalExam + perLabs + perProjects + perQuizzes + perAttendance);
		System.out.printf("Current Grade Score: %1.2f",currentScore);
		GradeScale finalLetterGrade;
		if (currentScore >= 0 && currentScore < 60) 
		{
			finalLetterGrade = GradeScale.F;
			System.out.println("\nYour current letter grade is a " + finalLetterGrade);
		}
		else if (currentScore >= 60 && currentScore <= 69) 
		{
			finalLetterGrade = GradeScale.D;
			System.out.println("\nYour current letter grade is a " + finalLetterGrade);
		}
		else if (currentScore >= 70 && currentScore <= 79) 
		{
			finalLetterGrade = GradeScale.C;
			System.out.println("\nYour current letter grade is a " + finalLetterGrade);
		}
		else if (currentScore >= 80 && currentScore <= 89) 
		{
			finalLetterGrade = GradeScale.B;
			System.out.println("\nYour current letter grade is a " + finalLetterGrade);
		}
		else if (currentScore >= 90 && currentScore <= 100) 
		{
			finalLetterGrade = GradeScale.A;
			System.out.println("\nYour current letter grade is a " + finalLetterGrade);
		}
		
		//calculating the minimum grade in the range of their grade
		if (desiredGrade.equalsIgnoreCase("A"))
		{
			finalOverallScore = 90;
		}
		else if (desiredGrade.equalsIgnoreCase("B"))
		{
			finalOverallScore = 80;
		}
		else if (desiredGrade.equalsIgnoreCase("C"))
		{
			finalOverallScore = 70;
		}
		else if (desiredGrade.equalsIgnoreCase("D"))
		{
			finalOverallScore = 60;
		}
		else if (desiredGrade.equalsIgnoreCase("F"))
		{
			finalOverallScore = 0;
		}
		
		//calculating whether the user got their desired grade if if all the scores are there
		if (perExamOne * perExamTwo * perFinalExam * perLabs * perProjects * perQuizzes * perAttendance != 0)
		{
			if (currentScore >= finalOverallScore)
			{
				System.out.println("Congratulations! You got the " + desiredGrade + " that you wanted.");
			}
			else if (currentScore < finalOverallScore)
			{
				System.out.println("Sorry you didn't end up with the " + desiredGrade + " that you wanted. Better luck next time!");
			}
		}
		else if (perExamOne * perExamTwo * perFinalExam * perLabs * perProjects * perQuizzes * perAttendance == 0)
		{
			//if the user does not have all their scores, we need to calculate whether they can achieve their desired grade in the course and what they have to get in order to do so 
			double sumWeightsAndScores = (totalExOne + totalExTwo + totalFinalEx + totalLabAv + totalProjAv +totalQuizAv + totalAttAv);
			double sumWeights = (perExamOne + perExamTwo + perFinalExam + perLabs + perProjects + perQuizzes + perAttendance);
			double avgToFinalLetterGrade = (double)((100 * finalOverallScore) - sumWeightsAndScores)/(double)(100 - sumWeights);
			if (avgToFinalLetterGrade <= 100 && avgToFinalLetterGrade > 0)
			{
				System.out.printf("\nTo get a/an " + desiredGrade + " in this course, you have to score an average greater than or equal to %1.2f", avgToFinalLetterGrade);
			}
			else if (avgToFinalLetterGrade > 100)
			{
				System.out.println("I'm sorry, but a/an " + desiredGrade + " is unachievable for you in this class considering your current grades");
			}
			else if (avgToFinalLetterGrade == 0)
			{
				System.out.println("You will achieve a/an " + desiredGrade + " no matter what");
			}
		}
			
	}
}	





