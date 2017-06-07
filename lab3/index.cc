#include <fstream>
#include <iostream>
#include <vector>

using namespace std;

// Implementation of bubble sort, similar to what you
// did in lab1.
void bubbleSort(vector<string>& words) {
  for (int i = 1; i < words.size(); ++i) {
    for (int j = 0; j < (words.size() - i); ++j) {
      if (words[j] > words[j+1]) {
        string tmp = words[j];
        words[j] = words[j+1];
        words[j+1] = tmp;
      }
    }
  }
}

vector<string> merge(const vector<string>& first,
                     const vector<string>& second) {
  vector<string> result;
  // Write your code to merge vectors first and
  // second onto result.
  return result;
}

void mergeSort(vector<string>& words) {
  if (words.size() <= 1) return;
  int n = words.size();
  int middle = n/2;

  vector<string> first_half(middle);
  for (int i = 0; i < middle; ++i) {
    first_half[i] = words[i];
  }

  vector<string> second_half(n - middle);
  for (int i = middle; i < n; ++i) {
    second_half[i - middle] = words[i];
  }

  // Add your code here to recursively sort the
  // first_half and second_half.

  words = merge(first_half, second_half);
}

void sort(vector<string>& words) {
  bubbleSort(words);
  // You will invoke mergeSort instead of bubbleSort here.
  // mergeSort(words);
}

// Opens a file, reads its contents to a vector of strings,
// containing one line each.
vector<string> readOneFile(const string& file) {
  ifstream input(file);
  vector<string> lines;
  if (input.is_open()) {
    string line;
    while (getline(input, line)) {
      lines.push_back(line);
    }
    input.close();
  } else {
    cout << "Could not read file " << file << endl;
  }
  return lines;
}

// Writes all the lines in the vector to file.
void writeOneFile(vector<string> lines, const string& file) {
  ofstream output(file, ofstream::out);
  cout << "Trying to write sorted words to file " << file << endl;
  if (output.is_open()) {
    for (auto line : lines) {
      output << line << endl;
    }
    output.close();
    cout << "Written to file " << file << endl;
  } else {
    cout << "Could not write to file " << file << endl;
  }
}

int main(int argc, char* argv[]) {
  if (argc != 2) {
    cout << "Pass exact one argument, the file to be sorted." << endl;
    return 1;
  }
  
  // Read the file.
  vector<string> lines = readOneFile(argv[1]);

  // Sort the lines.
  sort(lines);

  // Write sorted output.
  writeOneFile(lines, string(argv[1]) + ".sorted");
  
  return 0;
}