string extractUntilDelim(string s, int i, char delim) {
  int n = s.length();
  string ans;
  for (int j = i; j < n; j++) {
    if (s[j] == delim)
      return ans;
    else
      ans += s[j];
  }
  return ans;
}

// constraint: path must begin with a '/'.
// "/var/www/html/../.././lc" -> "/var/lc/"
// "/../../ -> "/"
string simplifyUnixFilePath(string path) {
  deque<string> directories;
  int n = path.length();
  for (int i = 0; i < n; i++) {
    char c = path[i];
    if (c == '/') continue;
    if (c == '.') {
      if (i+1 < n && path[i+1] == '.') {
        if (!directories.empty())
          directories.pop_back();
        continue;
      } else if (i+1 >= n || path[i+1] == '/') {
        continue;
      }
    }
    string dir = extractUntilDelim(path, i, '/');
    directories.push_back(dir);
    i += dir.length();
  }
  
  string ans = "/";
  while (!directories.empty()) {
    ans += directories.front() + "/";
    directories.pop_front();
  }
  return ans;
}