#include <iostream>

using namespace std;

// This function parses a number as a string, saves each digit
// in the num_array that is passed in, low-digits first, and
// returns the number of digits in that number.
// If we can't parse the number, returns -1.
// Example: If num_as_string = "1234",
//          then num_array[] = {4, 3, 2, 1} and
//          the return value is 4.
int readNumberAsArrayFromString(const string& num_as_string,
                                int* num_array) {
  for (int i = 0; i < num_as_string.length(); ++i) {
    if (num_as_string[i] >= '0' &&
        num_as_string[i] <= '9') {
      num_array[i] = static_cast<int>(num_as_string[i] - '0');
    } else {
      return -1;
    }
  }
  return num_as_string.length();
}

// Takes a number represented as an array with its digits,
// low to heigh, as well as its length (i.e. number of digits)
// and return a string representation of that number.
string numberAsArrayToString(int* num_array, int length) {
  if (length <= 0 ) {
    return "NaN";
  }
  string num_string;
  for (int i = 0; i < length; ++i) {
    num_string += static_cast<char>(num_array[i] + '0');
  }
  return num_string;
}

int main() {
  int first_number[1000000];
  int second_number[1000000];
  int first_number_length, second_number_length;
  cout << "Let's multiply two numbers." << endl;
  {
    cout << "Please enter the first number: ";
    string first_number_as_string;
    cin >> first_number_as_string;
    first_number_length = readNumberAsArrayFromString(
        first_number_as_string,
        first_number);
  }
  {
    cout << "Please enter the second number: ";
    string second_number_as_string;
    cin >> second_number_as_string;
    second_number_length = readNumberAsArrayFromString(
        second_number_as_string,
        second_number);
  }

  cout << "First number is : " << numberAsArrayToString(first_number, first_number_length) << endl;
  cout << "Second number is : " << numberAsArrayToString(second_number, second_number_length) << endl;

  // Now write your code here to multiply the two numbers
  // and print it out.

  return 0;
}
