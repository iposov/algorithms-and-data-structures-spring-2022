#include <iostream>
#include <cstring>
using namespace std;



int main(int argc, char **argv){

    if(argc == 4){
        char *name = argv[1];
        char *mode = argv[2];
        int k = atoi(argv[3]);
        char cmd[128];

        
        for(int i = 0; i < k; i++){
            if(strcmp("contains", mode) == 0)
                sprintf(cmd, "./%s <../%d.in >../results/my_%d.contains.out", name, (i+1), (i+1));
            else
                sprintf(cmd, "./%s <../%d.in >../results/my_%d.min-after.out", name, (i+1), (i+1));

            system(cmd);
            cout << "Test " << i+1 << " out file generated" << endl;
        }
        cout << endl;
        for(int i = 0; i < k; i++){
            if(strcmp("contains", mode) == 0)
                sprintf(cmd, "diff --strip-trailing-cr ../%d.contains.out ../results/my_%d.contains.out", (i+1), (i+1));
            else
                sprintf(cmd, "diff --strip-trailing-cr ../%d.min-after.out ../results/my_%d.min-after.out", (i+1), (i+1));

            int res = system(cmd);
            if(res == 0)
                cout << "Test " << i+1 <<": " << "success" << endl;
            else
                cout << "Test" << i+1 <<": " << "failed" << endl; 
        }
    }else{
        cout << "Передайте имя исполняемого файла, вариант (contains/min) и количество файлов с тестами" << endl;
    }

	

	return 0;
}