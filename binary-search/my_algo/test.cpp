#include <iostream>
#include <string>
using namespace std;



int main(int argc, char **argv){

    if(argc == 3){
        char *name = argv[1];
        int k = atoi(argv[2]);
        char cmd[128];

       
        for(int i = 0; i < k; i++){
            sprintf(cmd, "./%s <../%d.in >../results/my_%d.out", name, (i+1), (i+1));
            //cout << cmd << endl;  
            system(cmd);
            cout << "Test " << i+1 << " out file generated" << endl;
        }
        cout << endl;
        for(int i = 0; i < k; i++){
            sprintf(cmd, "diff ../%d.out ../results/my_%d.out", (i+1), (i+1));
            int res = system(cmd);
            if(res == 0)
                cout << "Test " << i+1 <<": " << "success" << endl;
            else
                cout << "Test" << i+1 <<": " << "failed" << endl; 
        }
    }else{
        cout << "Передайте имя исполняемого файла и количество файлов с тестами" << endl;
    }

	

	return 0;
}