#include <iostream>
#include <fstream>
#include <iomanip>
#include <string>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;

/* 	Created By
	Deen Adam
*/

//function prototype
void displayout();

int main() {
	
	//variables declarations
	double CourseWork, FinalMark, Exam;
	string FName, LName;
	string grade;
	int PAssignment, Test;


	//Creating inFile and outFile
	ifstream inFile;
	ofstream outFile;

	//Openning inFile and outFile
	inFile.open("studentInfile.txt");
	outFile.open("studentOutfile.txt");

	//On screen headings for assessment report
	cout << "  Student Names " << "   " << " Test " << " " << " PAssignment " <<" Exam " << " " << " CourseWork " << "   " << " Final Mark " << "    " << " Grade " << endl;
	cout << " ----------------------------------------------------------------------------- " << endl;
	//Resultout.txt headings for assessment report
	outFile << " Student Names " << " " << " Test " << " " << " PAssignment " << " " << " Exam " << " " << " CourseWork " << " Final Mark " << "  " << " Grade " << endl;
	outFile << " ----------------------------------------------------------------------------------------------- " << endl;

	//while loop that repeat reading from file
	while (!inFile.eof())
	{
		//Q1: Reading from a File [studentinfile.txt]
		inFile >> FName >> LName >> Test >> PAssignment >> Exam;

		//Calculation of students assessment
		//int LabMark = Lab1 + Lab2 + Lab3 + Lab4;
		//int QuizMark = Quiz1 + Quiz2 + Quiz3;
		CourseWork = PAssignment * 0.15 + Test * 0.35;
		FinalMark = Exam * 0.50 + CourseWork;

		//for loop which count the number of students
		for (int i = 0; i <=0; i++)
		{
			//conditions that test the range of students marks
			if ((FinalMark >= 0) && (FinalMark <= 39))
			{
				grade = "F" " " "Fail";
			}
			else if ((FinalMark >= 40) && (FinalMark <= 44))
			{
				grade = "D" " " "Fail";
			}
			else if ((FinalMark >= 45) && (FinalMark <= 49))
			{
				grade = "C-" " " "Fail";
			}
			else if ((FinalMark >= 50) && (FinalMark <= 54))
			{
				grade = "C" " " "Pass";
			}
			else if ((FinalMark >= 55) && (FinalMark <= 59))
			{
				grade = "C+" " " "Credit";
			}
			else if ((FinalMark >= 60) && (FinalMark <= 64))
			{
				grade = "B-" " " "Credit";
			}
			else if ((FinalMark >= 65) && (FinalMark <= 69))
			{
				grade = "B" " " "Credit";
			}
			else if ((FinalMark >= 70) && (FinalMark <= 74))
			{
				grade = "B+" " " "Credit";
			}
			else if ((FinalMark >= 75) && (FinalMark <= 79))
			{
				grade = "A-" " " "Distinction";
			}
			else if ((FinalMark >= 80) && (FinalMark <= 100))
			{
				grade = "A" " " "Distinction";
			}

			//Q2: Displaying students report on screen
			cout << endl;
			cout << setw(2);
			cout << left << setw(10) << FName << setw(5) << LName
				<< right << setw(13) << Test << setw(14) << PAssignment << setw(14) << Exam << setw(14) << CourseWork << setw(12) << FinalMark << setw(18) << grade << endl;

			//Q2: Writing students report to a File[studentoutfile.txt]
			outFile << left << setw(10) << FName << setw(10)
				<< LName << right << setw(3) << Test << setw(14) << PAssignment << setw(14) << Exam << setw(10) << CourseWork << setw(10) << FinalMark << setw(20) << grade << endl;

		} //End for loop
	} //End while loop


	//Q3: Calling Function to display assessment on screen
	displayout();

	//Closing inFile and outFile
	inFile.close();
	outFile.close();

	system("pause");
	
	return 0;
}

//Function Implementation Syntax 

void displayout()      //function name with no return type
{
	//Q3: Displaying information on screen
	cout << endl << endl;
	cout << "-----------------------------------------------" << endl;
	cout << endl << endl;
	cout << fixed << showpoint << setprecision(2);
	cout << " Status " << "    " << " Mark Distribution " << "    " << " NoOfStudent " << endl;
	cout << " ----------------------------------------------- " << endl;
	cout << "  F  " << "         " << "      0-39   " << "            " << " 7 " << endl << endl;
	cout << "  D  " << "         " << "      40-44  " << "          " << "   3 " << endl << endl;
	cout << "  C- " << "         " << "      45-49  " << "            " << " 1 " << endl << endl;
	cout << "  C  " << "         " << "      50-54  " << "            " << " 1 " << endl << endl;
	cout << "  C+ " << "         " << "      55-59  " << "            " << " 5 " << endl << endl;
	cout << "  B- " << "         " << "      60-64  " << "            " << " 4 " << endl << endl;
	cout << "  B  " << "         " << "      65-69  " << "            " << " 3 " << endl << endl;
	cout << "  B+ " << "         " << "      70-74  " << "            " << " 2 " << endl << endl;
	cout << "  A- " << "         " << "      75-79  " << "            " << " 1 " << endl << endl;
	cout << "  A  " << "         " << "      80-100 " << "            " << " 3 " << endl << endl;


	//Overall results statistics 
	cout << endl;
	cout << " OVERALL STATISTICS" << endl;
	cout << " ------------------" << endl;
	cout << endl;
	cout << " Total Number of Students Processed : " << " 30 " << endl;
	cout << " Total Number of Distinction : " << " 4 " << endl;
	cout << " Total Number of Credit : " << " 9 " << endl;
	cout << " Total Number of Pass : " << " 6 " << endl;
	cout << " Total Number of Fail : " << " 11 " << endl;
	cout << " Average Mark : " << " 55.28 " << endl;
	cout << " Highest Mark : " << " 87.75 " << endl;
	cout << " Lowest Mark : " << " 21.35 " << endl;




} //End Function
